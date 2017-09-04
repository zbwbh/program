package com.baseframe.core;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.parser.ParserConfig;
import com.baseframe.redis.datasource.RedisDataSource;
import com.baseframe.redis.util.RedisClientTemplate;
import com.baseframe.service.CarBrandService;
import com.baseframe.service.RegionService;
import com.baseframe.util.Constants;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

@Service("LOADCACHE")
public class LoadCache implements InitializingBean{
    
    private static final Logger log = LoggerFactory.getLogger(LoadCache.class);
    
    @Resource
    private RedisClientTemplate redisClientTemplate;
    
    @Resource
    private RedisDataSource redisDataSource;
    
    @Resource
    private RegionService regionService;
    
    @Resource
    private CarBrandService carBrandService;
    
    public void afterPropertiesSet() throws Exception {
        try {
            log.error("开始加载baseframe数据...");
            regionService.setRegionsFromRedis();
            carBrandService.setCarBrandByFirstLetterGroup();
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
    
    //PostConstruce优先级高于InitializingBean
    //此方法优先加载redis数据
    @PostConstruct
    public void loadCache() {
        log.info("开始加载redis ....");
        try {
            ParserConfig.getGlobalInstance().setAsmEnable(false);
            redisClientTemplate.setKey("testContent", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            Jedis j = null;
            ShardedJedis shardedJedis = redisDataSource.getRedisClient();
            Collection<Jedis> c = shardedJedis.getAllShards();
            Iterator<Jedis> it = c.iterator();
            while(it.hasNext()){
                j = it.next();
                String jedisInfo = j.info("server").replaceAll("\r|\n", " ");
                jedisInfo = jedisInfo.substring(jedisInfo.indexOf("process_id:"), jedisInfo.indexOf("uptime_in_seconds:"));
                redisClientTemplate.setKey(Constants.REDIS_SERVER_KEY, jedisInfo);
                break;
            }
            
            Enumeration<URL> e = Thread.currentThread().getContextClassLoader().getResources("com/change/test/redis/script");
            while(e.hasMoreElements()){
                File f = new File(e.nextElement().toURI());
                File []files = f.listFiles();
                for(File file :files){
                    String content = FileUtils.readFileToString(file,"UTF-8");
                    String key = "";
                    if(file.getName().indexOf(".")!=-1){
                        key = file.getName().substring(0,file.getName().indexOf("."));
                    }else{
                        key = file.getName();
                    }
                    String sha = j.scriptLoad(content);
                    Map<String,Object> value = new HashMap<String,Object>();
                    value.put(key, sha);
                    redisClientTemplate.setCacheMap(Constants.REDIS_SCRIPT, value);
                    j.close();
                    log.info("Redis 脚本加载完成，key:"+key+",sha:"+sha);
                }
            }
            log.info("Frame cache loading end.加载结束");
        }
        catch (Exception e) {
            log.info("系统加载缓存失败，自动关闭缓存");
        }
    }
    
    @PreDestroy
    public void destory(){
        redisClientTemplate.delKey("testContent");
        redisClientTemplate.delKey(Constants.REDIS_SCRIPT);
        redisClientTemplate.delKey(Constants.REDIS_SERVER_KEY);
    }
}

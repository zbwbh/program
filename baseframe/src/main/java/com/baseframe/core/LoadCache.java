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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.parser.ParserConfig;
import com.baseframe.redis.datasource.RedisDataSource;
import com.baseframe.redis.util.RedisClientTemplate;
import com.baseframe.service.RegionService;
import com.baseframe.util.Constants;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

/**
 * 
 * 使用controller注解和service注解都可以加载，但是controller输出两次
 * 并且InitializingBean的初始化顺序比@PostConstruct慢
 *
 * @author koala
 * @since 2017年6月12日
 */
@Service("loadDEMODB")
public class LoadCache implements InitializingBean {

    private static final Logger log = Logger.getLogger(LoadCache.class);
    
    @Resource
    private RedisClientTemplate redisClientTemplate;
    
    @Resource
    private RedisDataSource redisDataSource;
    
    @Resource
    private RegionService regionService;
    
    public void afterPropertiesSet() throws Exception {
        try {
            regionService.setRegionsFromRedis();
        }
        catch (Exception e) {
            log.error("发生什么了",e);
        }
    }
    
    /**
     * 
     * PostConstruct该注解代表该方法在类初始化的时候执行的方法，可以指定多个，如果是其他方式比如init-method的话就只能使用一次
     * 并且在当前类中，类上面添加的注解可以是任何一种@controller或者是@service两种都可以，并且不需要实现，只要保证在扫描的时候
     * 可以扫到该类该方法就可以直接初始化，该方法就会生效，@PreDestroy是同理的,但是要注意，如果是@controller的话，控制台会输出两次
     * 如果是@service就只输出一次，这个莫非是扫描时候的问题？？看情况而定吧
     * @author koala
     * @since 2017年6月12日
     */
    @PostConstruct
    public void loadCache(){
        log.info("开始加载redis ....");
        try {
            /*
             * fastJson在序列化和反序列化的时候是默认开启ASM的，所以下面的方法是
             * 反序列化的时候关闭ASM
             */
            ParserConfig.getGlobalInstance().setAsmEnable(false);
          //setKey中使用了setnx命令，该命令意味将key的值设置为value(需要在value不存在的情况下，如果value存在，那么该命令不做任何动作)
            redisClientTemplate.setKey("testContent", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            Jedis j = null;
          //getRedisClient()里面封装了获取资源建立连接的方法getResource(),采用的是redis分布式集群，实际上就是Jedis分片
            ShardedJedis shardedJedis = redisDataSource.getRedisClient();
          //获取所有的缓存实例，估计是每台机器上的Jedis（后面这个是我自己理解的）
            Collection<Jedis> c = shardedJedis.getAllShards();
            Iterator<Jedis> it = c.iterator();
            while(it.hasNext()){
                j = it.next();
                /*
                 * 备注是的两行就是整个一个完整的jedis里面的info
                 * 几乎可以看到redis的所有信息，然后通过下面的replaceAll方法将回车以及换行都替换成空字符串，但是是占有字节的
                 * ，也就是说结果中的每个元素都有空格隔开的
                 */
//                String k = j.info();
//                System.out.println(k);
                String jedisInfo = j.info("server").replaceAll("\r|\n", " ");
//                log.info("没截取jedisInfo之前:"+ jedisInfo);
                jedisInfo = jedisInfo.substring(jedisInfo.indexOf("process_id:"), jedisInfo.indexOf("uptime_in_seconds:"));
//                log.info("截取之后的jedisInfo是："+jedisInfo);
                redisClientTemplate.setKey(Constants.REDIS_SERVER_KEY, jedisInfo);
                break;
            }
            /**
             * Enumeration接口提供了一套标准的方法，由于Enumeration是一个接口，他的角色局限于为数据结构提供方法协议
             * 该接口内部含有两个方法，一个是boolean类型的hasMoreElements()，用于查看枚举对象中是否还含有元素，如果
             * 返回true，则表示还含有至少一个元素
             * 第二个是Object类型的nextElement()，如果枚举对象还含有元素，该方法得到对象中的下一个元素
             * 
             * 后面的部分：加载当前线程中的类，并获取其中的资源，用这种方法可以避免大小范围的差异化，因为classpath里面
             * 加载的类有很多种方法，有可能是系统类，或者其他什么的，比如classpath下面的jre(运行环境)有lib，lib下面有ext，
             * 他说加载的范围是不一样的，这种方式可以有效避免从大到小不能精准定位的问题（暂时先这么理解吧，我估计不准）
             * 
             * 获取的是项目文件夹redis/script内部的脚本文件
             * 
             * URL和URN都属于URI的子集，其中URL最后一个单词为locators，代表位置，定位，所以他代表一个东西的具体位置，而
             * URN最后一个单词为names，代表名字，命名，所以他代表一个名字，URN和URL整体组成了URI
             */
            Enumeration<URL> e = Thread.currentThread().getContextClassLoader().getResources("com/change/test/redis/script");
            while(e.hasMoreElements()){
                File f = new File(e.nextElement().toURI());
//                log.info("f:"+f);
                File []files = f.listFiles();
                for(File file :files){
                    String content = FileUtils.readFileToString(file,"UTF-8");
//                    log.info("content是："+content);//实际上就是把文件中的内容都转换成字符串了，一个长字符串，并且格式跟文件里的内容一样，只不过格式已经是String了
                    String key = "";
                    if(file.getName().indexOf(".")!=-1){
                        key = file.getName().substring(0,file.getName().indexOf("."));
                    }else{
                        key = file.getName();
                    }
//                    log.info("key是:"+key);
                    /*
                     * scriptLoad命令：
                     * 将脚本script添加到脚本缓存中，但不立即执行这个脚本
                     * EVAL命令也会将脚本添加到脚本缓存中，但是他会立即对输入的脚本进行求值。
                     * 如果给定的脚本已经在缓存里面了，那么不做动作。
                     * 在脚本被加入到缓存之后，通过EVALSHA命令，可以使用脚本的SHA1校验和来调用这个脚本。
                     * 脚本可以在缓存中保留无限长的时间，知道执行SCRIPT FLUSH位置
                     */
                    String sha = j.scriptLoad(content);
//                    log.info("sha是："+sha);
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

    /**
     * 原始的那个service接口里面也没有这个方法，是不是通过PreDestroy注解可以在销毁的时候可以直接访问这个方法？
     *
     * @author koala
     * @since 2017年6月12日
     */
    @PreDestroy
    public void destroy(){
        redisClientTemplate.delKey("testContent");
        redisClientTemplate.delKey(Constants.REDIS_SCRIPT);
        redisClientTemplate.delKey(Constants.REDIS_SERVER_KEY);
    }
}

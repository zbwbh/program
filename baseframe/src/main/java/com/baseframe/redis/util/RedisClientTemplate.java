package com.baseframe.redis.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baseframe.redis.datasource.RedisDataSource;
import com.baseframe.util.Constants;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

/**
 * 
 * redis核心操作类，主要针对的是redis的命令
 * 不过是java操作了redis，也就是jedis，这么来的
 * 
 * 该类没有实现接口，那么@Repository注解就是为了spring容器可以找到他(bean)并进行管理
 * </br>
 * 
 * I saw this code for three times. </br>
 * Now I've found that different methods have the same command</br>
 * So please refer to the <a href="http://doc.redisfans.com/">redis command</a>
 * 
 * @author koala
 * @since 2017年7月27日
 */
@Repository
public class RedisClientTemplate {

    private static final Logger log = LoggerFactory.getLogger(RedisClientTemplate.class);
    
    /*
     * 上面提到了spring容器找到bean管理，那么这里的注入就是将额外的bean添加到该bean进行融合
     * 跟对象引用是一个类似的概念啊
     */
    @Resource
    private RedisDataSource redisDataSource;
    
    public ShardedJedis getShardedJedis(){
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        return shardedJedis;
    }
    
    public void disconnect() {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        shardedJedis.disconnect();
    }
    public void delKey(String key) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        shardedJedis.del(key);
        shardedJedis.disconnect();
        shardedJedis.close();
    }
    
    public void setKey(String key,String value) {
        if(Constants.isConnectCatch()){
            try {
                ShardedJedis shardedJedis = redisDataSource.getRedisClient();
                shardedJedis.set(key, value);
                shardedJedis.disconnect();
                shardedJedis.close();
            }
            catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
    }
    
    public Object getKey(String key) {
        if(Constants.isConnectCatch()){
            try {
                ShardedJedis shardedJedis = this.getShardedJedis();
                Object obj = shardedJedis.get(key);
                this.disconnect();
                shardedJedis.close();
                return obj;
            }
            catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }    
        }
        return null;
    }

    public void setList(String key,List<?>list) {
        if(Constants.isConnectCatch()){
            try {
                ShardedJedis shardedJedis = this.getShardedJedis();
                shardedJedis.set(key, JSONArray.toJSONString(list));
                shardedJedis.disconnect();
                shardedJedis.close();
            }
            catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
    }
    
    public void setMap(String key,Map<String,Object> map) {
        if(Constants.isConnectCatch()){
            try {
                ShardedJedis shardedJedis = this.getShardedJedis();
                shardedJedis.set(key, JSONArray.toJSONString(map));
                shardedJedis.disconnect();
                shardedJedis.close();
            }
            catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
    }
    public void setCacheSet(String key,String json) {
        if(Constants.isConnectCatch()){
            try {
                ShardedJedis shardedJedis = this.getShardedJedis();
                shardedJedis.sadd(key, json);
                shardedJedis.disconnect();
                shardedJedis.close();
            }
            catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
    }
   
    public String getCacheSetFirst(String key) {
        if(Constants.isConnectCatch()){
            try {
                String result = null;
                ShardedJedis shardedJedis = this.getShardedJedis();
                Set<String> set = shardedJedis.smembers(key);
                Iterator<String> it = set.iterator();
                if(null!=set && !set.isEmpty()){
                    while(it.hasNext()) {
                        result = it.next();
                        break;
                    }
                    return result;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        return null;
    }
    
    public List<String> getCacheMap(String key, String ...fields) {
        if(Constants.isConnectCatch()){
            try {
                ShardedJedis shardedJedis = this.getShardedJedis();
                List<String> list = shardedJedis.hmget(key, fields);
                shardedJedis.disconnect();
                shardedJedis.close();
                return list;
            }
            catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        return null;
    }
    
    public void setCacheMap(String key,Map<String,Object>map){
        if(Constants.isConnectCatch()){
            try {
                if(null!=map&&!map.isEmpty()){
                    Map<String,String>m1 = new HashMap<String,String>();
                    Set<Entry<String,Object>>entrySet = map.entrySet();
                    for(Entry<String,Object> entry:entrySet){
                        Object value = entry.getValue();
                        if(value instanceof String){
                            m1.put(entry.getKey(), (String)value);
                        }
                        else{
                            m1.put(entry.getKey(), JSON.toJSONString(value));
                        }
                    }
                    ShardedJedis shardedJedis = this.getShardedJedis();
                    shardedJedis.hmset(key, m1);
                    shardedJedis.disconnect();
                    shardedJedis.close();
                }
            }
            catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
    
    private Jedis getJedis() {
        String cacheRedisServerKey = (String)(this.getKey(Constants.REDIS_SERVER_KEY));
        Jedis jedis = null;
        ShardedJedis shardedJedis = this.getShardedJedis();
        Collection<Jedis> jediscol = shardedJedis.getAllShards();
        Iterator<Jedis> it = jediscol.iterator();
        while(it.hasNext()){
            Jedis j = it.next();
            System.out.println(j.info("server"));
            String jedisInfo = j.info("server").replaceAll("\r|\n", " ");
            jedisInfo = jedisInfo.substring(jedisInfo.indexOf("process_id:"), jedisInfo.indexOf("uptime_in_seconds:"));
            if(cacheRedisServerKey.equals(jedisInfo)) {
                jedis = j;
                break;
            }
        }
        shardedJedis.disconnect();
        shardedJedis.close();
        return jedis;
    }
    
    public <T> List<T> getCacheSetFuzzyKey(String fuzzyKey,Class<T>clazz) {
        if(Constants.isConnectCatch()){
            List<String> setFuzzyKeyScriptSha = this.getCacheMap(fuzzyKey, Constants.REDIS_SCRIPT);
            Jedis jedis = getJedis();
            if(null!=jedis) {
                List<String> list = (List<String>)jedis.evalsha(setFuzzyKeyScriptSha.get(0), 1, fuzzyKey);
                jedis.disconnect();
                jedis.close();
                if(null!=list && list.size()>0) {
                    return JSON.parseArray(list.toString(),clazz);
                }else{
                    return new ArrayList();
                }
            }else{
                return null;
            }
        }
        return null;
    }
}

package com.baseframe.redis.datasource;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * redis集群连接和相应的关闭，只是封装的建立连接和关闭的方法
 * 在外面只要在需要的时候引用相应的方法就好了，没有什么具体要求
 * 
 *
 * @author koala
 * @since 2017年6月9日
 */
@Repository("redisDataSource")
public class RedisDataSourceImpl implements RedisDataSource {

    private static final Log log = LogFactory.getLog(RedisDataSourceImpl.class);
    
    @Resource
    private ShardedJedisPool shardedJedisPool;
    
    //获得连接
    public ShardedJedis getRedisClient() {
        try {
            //这里不写try...catch的话编译不报错，是不是为了防止出现Could not get a resource from the pool异常啊？
            ShardedJedis shardedJedis = shardedJedisPool.getResource();
            return shardedJedis;
        }
        catch (Exception e) {
            //这里的log应该是不起作用的，应该是，不确定啊
            log.error("getRedisClent error", e);
        }
        return null;
    }

    /**
     * 这个方法始终是没用上，都是直接写shardedJedis.close()了，谁费那么大劲在调用这个方法啊，而且代码读起来也费尽
     * 代码始终是给人看的，不是给机器看的
     * 
     * @author koala
     * @since 2017年6月9日
     */
    public void returnResource(ShardedJedis shardedJedis) {
        shardedJedis.close();
    }

    public void closeSystemRedis() {

    }

}

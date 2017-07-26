package com.baseframe.redis.datasource;

import redis.clients.jedis.ShardedJedis;

/**
 * 
 * 
 *
 * @author koala
 * @since 2017年6月9日
 */
public interface RedisDataSource {

    //开始的时候我没有写abstract，是在不明白怎么多出来一个抽象
    public ShardedJedis getRedisClient();
    
    //貌似这个方法根本就没用上啊，在jedis模板那个类里面没找到这个啊
    public void returnResource(ShardedJedis shardedJedis);
    
    public void closeSystemRedis();
}

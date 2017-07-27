package com.baseframe.redis.datasource;

import redis.clients.jedis.ShardedJedis;

public interface RedisDataSource {

    public ShardedJedis getRedisClient();
}

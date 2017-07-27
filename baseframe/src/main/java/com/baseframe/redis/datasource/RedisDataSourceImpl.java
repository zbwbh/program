package com.baseframe.redis.datasource;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 因为该类不是mybatis集成的，所以还是采用原始的注解的方式找到该类
 * 就要使用@Repository注解，并且要实现相应的接口，
 * 注意spring当中的dao，service，controller的注解一定是在类上添加的，跟接口没有关系，因为只有类
 * 有相应的实例才会创建相应的bean
 *
 * @author koala
 * @since 2017年7月27日
 */
@Repository("redisDataSource")
public class RedisDataSourceImpl implements RedisDataSource {

    private static final Logger log = LoggerFactory.getLogger(RedisDataSourceImpl.class);
    
    @Resource
    private ShardedJedisPool shardedJedisPool;
    
    public ShardedJedis getRedisClient() {
        
        try {
          //这里不写try...catch的话编译不报错，是不是为了防止出现Could not get a resource from the pool异常啊？
            //还有这个只是获得一个连接，如果可以的话是直接在相应的类里面使用getResource方法的，
            //其实也没差哪去，因为你在外面还要首先注入当前RedisDataSource接口，所以他们的代码量差不多，除非还要在下面额外加上其他的方法
            ShardedJedis shardedJedis = shardedJedisPool.getResource();
            return shardedJedis;
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return null;
    }

}

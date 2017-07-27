package com.baseframe.redis.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.baseframe.redis.datasource.RedisDataSource;

/**
 * 
 * redis核心操作类，主要针对的是redis的命令
 * 不过是java操作了redis，也就是jedis，这么来的
 * 
 * 该类没有实现接口，那么@Repository注解就是为了spring容器可以找到他(bean)并进行管理
 * @author koala
 * @since 2017年7月27日
 */
@Repository
public class RedisClientTemplate {

    /*
     * 上面提到了spring容器找到bean管理，那么这里的注入就是将额外的bean添加到该bean进行融合
     * 跟对象引用是一个类似的概念啊
     */
    @Resource
    private RedisDataSource redisDataSource;
    
    
}

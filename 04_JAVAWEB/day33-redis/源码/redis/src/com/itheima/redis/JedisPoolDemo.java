package com.itheima.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 内存数据库redis的连接池
 *
 * 连接池对象，方法 返回 Jedis对象
 */
public class JedisPoolDemo {
    public static void main(String[] args) {
        //创建对象，连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //进行配置
        config.setMaxIdle(50); //最大空闲时间
        config.setMaxTotal(10);//连接池中的最大连接数

        //创建连接池对象，构造方法中，传递配置对象
        JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);

        //连接池对象返回jedis
        Jedis jedis =  jedisPool.getResource();
        String value = jedis.get("heima");
        System.out.println(value);
        jedis.close();
    }
}

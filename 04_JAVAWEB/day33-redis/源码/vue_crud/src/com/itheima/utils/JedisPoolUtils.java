package com.itheima.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * 读取配置文件
 * 创建连接池对象
 * 返回连接 Jedis对象
 */
public class JedisPoolUtils {
    private  static JedisPool pool;
    static {
        //ResourceBundle读取配置文件
        ResourceBundle bundle =  ResourceBundle.getBundle("redis");
        int maxTotal = Integer.parseInt(bundle.getString("maxTotal"));
        String host = bundle.getString("host");
        int port = Integer.parseInt(bundle.getString("port"));
        //创建连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);

        //创建连接池对象
        pool = new JedisPool(config,host,port);
    }

    //静态方法，返回redis数据库的连接对象jedis
    public static Jedis getJedis(){
        //连接池对象的方法 getResource()拿到Jedis对象
       return pool.getResource();
    }
}

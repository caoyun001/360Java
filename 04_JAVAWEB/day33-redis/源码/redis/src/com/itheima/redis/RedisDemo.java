package com.itheima.redis;

import redis.clients.jedis.Jedis;

/**
 *  Java连接数据库 （redis）内存数据
 *  驱动包中的核心类 Jedis
 */
public class RedisDemo {
    public static void main(String[] args) {
        getString();
//        setString();
    }
    //取出redis数据库中的值
    public static void getString(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        String value = jedis.get("heima2");
        System.out.println(value);
        jedis.close();
    }


    //Java向redis数据库存储字符串的键值对
    public static void setString(){
        //创建 Jedis对象
        //构造方法中，传递数据库IP和端口
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //向数据库中存储字符串
        //redis数据库中的命令，就是Java中的方法名
        jedis.set("heima","你好");

        jedis.close();
    }
}

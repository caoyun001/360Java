package com.itheima.redis;

import com.itheima.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 *  测试连接池工具类
 */
public class TestJedisPooo {
    public static void main(String[] args) {
//        getString();
//        setList();
//        getList();
//        setHash();
        getHash();
    }
    /**
     * 取出数据类型，散列hash
     */
    public static void getHash(){
        Jedis jedis = JedisPoolUtils.getJedis();
        String value = jedis.hget("mySet", "hehe");
        System.out.println(value);
        jedis.close();
    }

    /**
     * 存储数据类型，散列hash
     * String = 值Map<String,String>
     */
    public static void setHash(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.hset("mySet","hehe","xixi");
        jedis.close();
    }

    /**
     * 取出类型list
     */
    public static void getList(){
        Jedis jedis = JedisPoolUtils.getJedis();
        List<String> stringList = jedis.lrange("mylist",0,-1);
        jedis.close();

        for (int i = 0; i < stringList.size(); i++) {
            String s =  stringList.get(i);
            System.out.println(s);
        }
    }

    /**
     * 数据类型 list
     * 一个键对应多个值
     */
    public static void setList(){
        Jedis jedis = JedisPoolUtils.getJedis();
        //左侧推入元素
        jedis.lpush("mylist","a","b","c","d");
        jedis.close();
    }


    //读取数据库中的 键 heima
    public static void getString(){
        Jedis jedis = JedisPoolUtils.getJedis();
        String value = jedis.get("heima");
        System.out.println(value);

        jedis.close();
    }

}

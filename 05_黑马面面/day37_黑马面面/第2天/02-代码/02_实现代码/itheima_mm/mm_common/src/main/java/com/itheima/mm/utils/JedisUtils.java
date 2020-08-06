package com.itheima.mm.utils;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/22
 * @description ：Jedis工具类
 * @version: 1.0
 */
@Slf4j
public class JedisUtils {
	private static JedisPoolConfig poolConfig = null;
	private static JedisPool jedisPool = null;
	private static Integer maxTotal = null;
	private static Integer maxIdle = null;
	private static String host = null;
	private static Integer port = null;

	public static void init(ResourceBundle rb){
		//读取配置文件 获得参数值
		//ResourceBundle rb = ResourceBundle.getBundle("jedis");
		maxTotal = Integer.parseInt(rb.getString("jedis.maxTotal"));
		maxIdle = Integer.parseInt(rb.getString("jedis.maxIdle"));
		port = Integer.parseInt(rb.getString("jedis.port"));
		host = rb.getString("jedis.host");
		poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(maxTotal);
		poolConfig.setMaxIdle(maxIdle);
		jedisPool = new JedisPool(poolConfig,host,port);
		log.info("init jedis resource,host:{},port:{}",host,port);
	}

	public static boolean isUsed(){
		try{
			return jedisPool != null && jedisPool.getResource().isConnected();
		}catch(Exception e){
		    return false;
		}

	}

	public static Jedis getResource(){
		return jedisPool.getResource();
	}
}

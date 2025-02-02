package com.horo.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName jedisConnectionFactory
 * @Author iove
 * @Date 2025/2/2 下午2:04
 * @Version 1.0
 * @Description TODO
 **/

public class jedisConnectionFactory {
	public static JedisPool jedisPool;
	static {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(8);
		jedisPoolConfig.setMaxIdle(8);
		jedisPoolConfig.setMinIdle(8);
		jedisPoolConfig.setMaxWaitMillis(200);
		jedisPool=new JedisPool(jedisPoolConfig, "127.0.0.1", 6379,1000,"123456");

	}
	public static Jedis getJedis(){
		return jedisPool.getResource();
	}
}

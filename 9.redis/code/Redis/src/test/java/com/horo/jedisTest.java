package com.horo;

import com.horo.util.jedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @ClassName jedisTest
 * @Author iove
 * @Date 2025/2/2 下午1:27
 * @Version 1.0
 * @Description TODO
 **/

public class jedisTest {
	private Jedis jedis;
	@BeforeEach
	public void setUp() {
//		jedis = new Jedis("127.0.0.1", 6379);
//		jedis.auth("123456");
//		jedis.select(0);
		jedis= jedisConnectionFactory.getJedis();
	}
	@Test
	public void stringTest(){
		String result = jedis.set("na", "Asuka");
		System.out.println(result);
		String name = jedis.get("na");
		System.out.println(name);
	}
	@Test
	public void hashTest(){
		long result = jedis.hset("horo:user:1", "username", "Asuka");
		System.out.println(result);
		String username = jedis.hget("horo:user:1", "username");
		System.out.println(username);
	}
	@AfterEach
	public void tearDown() {
		if(jedis != null){
			jedis.close();
		}
	}
}

package com.horo;

import com.horo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

/**
 * @ClassName springDataRedisTest
 * @Author iove
 * @Date 2025/2/2 下午2:35
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootTest
public class SpringDataRedisTest {
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void testRedisTemplate() {
		redisTemplate.opsForValue().set("redisTemplate", "daydayup");
		Object result = redisTemplate.opsForValue().get("redisTemplate");
		System.out.println(result);
		redisTemplate.opsForValue().set("User", new User("明日香","123456",17));
		User user= (User) redisTemplate.opsForValue().get("User");
		System.out.println(user);
	}


	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Test
	public void testString() {
		stringRedisTemplate.opsForValue().set("stringRedisTemplate", "hello");
		String hello = (String) stringRedisTemplate.opsForValue().get("stringRedisTemplate");
		System.out.println(hello);
	}
	@Test
	public void testHash(){
		HashOperations hashOperations = redisTemplate.opsForHash();
		hashOperations.put("User:1","username","Asuka");
		hashOperations.put("User:1","password","123456");
		Map user = hashOperations.entries("User:1");
		System.out.println(user);
	}
}

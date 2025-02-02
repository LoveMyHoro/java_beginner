package com.horo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @ClassName RedsiConfiguration
 * @Author iove
 * @Date 2025/2/2 下午3:48
 * @Version 1.0
 * @Description TODO
 **/
@Configuration
public class RedisConfiguration {
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		//1.常见RedisTemplate
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		//2.常见连接工厂
		redisTemplate.setConnectionFactory(factory);
		//获取json序列化器
		GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
		//3.为key和value添加自己需要的序列化器
		redisTemplate.setKeySerializer(RedisSerializer.string());
		redisTemplate.setHashKeySerializer(RedisSerializer.string());

		redisTemplate.setValueSerializer(jsonRedisSerializer);
		redisTemplate.setHashValueSerializer(jsonRedisSerializer);
		return redisTemplate;
	}
}

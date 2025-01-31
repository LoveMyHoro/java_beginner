package com.horo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisTest
 * @Author iove
 * @Date 2024/11/5 下午8:57
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * redis存储键值对并设置过期时间
     */
    @Test
    public void testSet() {
        stringRedisTemplate.opsForValue().set("hello", "world", 15,TimeUnit.SECONDS);
    }

    /**
     * redis获取键值对
     */
    @Test
    public void testGet() {
        System.out.println(stringRedisTemplate.opsForValue().get("hello"));
    }

}

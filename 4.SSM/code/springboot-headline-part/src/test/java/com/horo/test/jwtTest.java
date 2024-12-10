package com.horo.test;

import com.horo.utils.JwtHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName test
 * @Author iove
 * @Date 2024/10/28 下午4:59
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootTest
public class jwtTest {
    @Autowired
    private JwtHelper jwtHelper;
    @Test
    public void test() {
        //1.传入id生成用户标识
        String token=jwtHelper.createToken(1L);
        System.out.println("用户标识="+token);

        //2.根据用户标识获取用户id
        Long userId=jwtHelper.getUserId(token);
        System.out.println("用户id="+userId);

        //3.判断用户标识是否过期
        boolean expiration=jwtHelper.isExpiration(token);
        System.out.println("是否过期="+expiration);


    }
}

package com.horo.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.horo.mapper.UserMapper;
import com.horo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName LambdaQueryWrapperTest
 * @Author iove
 * @Date 2024/10/27 上午12:07
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootTest
public class LambdaQueryWrapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testLambdaQueryWrapper() {
        //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE username LIKE ? AND age > ? OR email IS NULL)
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //就是把形参名换成了参数引用
        lambdaQueryWrapper.like(User::getName,"a").gt(User::getAge,20).or().isNull(User::getEmail);
        User user = new User();
        user.setAge(18);
        user.setEmail("a@qq.com");
        int result = userMapper.update(user, lambdaQueryWrapper);
        System.out.println("受影响行数="+result);
    }
}

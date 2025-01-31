package com.horo.controller;

import com.horo.pojo.User;
import com.horo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TestController
 * @Author iove
 * @Date 2024/11/1 下午3:15
 * @Version 1.0
 * @Description TODO 测试连通性专用controller
 **/
@RestController
@RequestMapping("/user")
public class TestController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> users=userService.findAll();
        return users;
    }
}

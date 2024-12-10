package com.horo.controller;

import com.horo.pojo.User;
import com.horo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Author iove
 * @Date 2024/10/27 下午5:20
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("findAll")
    public List findAll() {
        List<User> users = userService.queryAll();
        return users;
    }
}

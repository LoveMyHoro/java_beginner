package com.horo.controller;

import com.horo.pojo.User;
import com.horo.service.UserService;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName HelloController
 * @Author iove
 * @Date 2024/10/31 上午11:15
 * @Version 1.0
 * @Description TODO
 **/

@RestController
public class HelloController {
    @Autowired
    private UserService userService;
    @Value("${person.hobbies}")
    private List<String> list;
    @RequestMapping("/hello")
    public String hello() {
        return "Hello springboot3"+list;
    }
    @GetMapping("/findById")
    public User findAll(Integer uid) {
        User user=userService.getById(uid);
        System.out.println("uid:"+uid+",user:"+user);
        return user;
    }
}

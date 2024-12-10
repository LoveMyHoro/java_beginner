package com.horo.controller;

import com.horo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author iove
 * @Date 2024/10/23 下午9:01
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("hello")
public class HelloController {
    @Autowired
    private User user;
    @GetMapping("show")
    public String show() {
        return user.toString();
    }
}

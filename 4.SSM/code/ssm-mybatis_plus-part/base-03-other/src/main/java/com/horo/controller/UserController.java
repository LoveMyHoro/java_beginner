package com.horo.controller;

import com.horo.pojo.User;
import com.horo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Author iove
 * @Date 2024/10/27 下午6:45
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> list=userService.findAll();
        return list;
    }

}

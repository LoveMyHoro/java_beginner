package com.horo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Author iove
 * @Date 2024/10/18 下午3:03
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("/user2")
public class UserController2 {
    @GetMapping("/data1")
    public String data() {
        //空指针异常NullPointerException
        String name=null;
        System.out.println("user2 data");
        //name.toString();
        return "ok";
    }
    @GetMapping("/data2")
    public String data2() {
        System.out.println("user2 data2");
        //算术异常ArithmeticException
        //int i=1/0;
        return "ok";
    }
}

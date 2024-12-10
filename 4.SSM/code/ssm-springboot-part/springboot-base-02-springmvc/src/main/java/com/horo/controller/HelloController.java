package com.horo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author iove
 * @Date 2024/10/25 下午3:13
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping
public class HelloController {
    @RequestMapping("/show")
    public String show(){
        System.out.println("hello");
        return "hello";
    }
}

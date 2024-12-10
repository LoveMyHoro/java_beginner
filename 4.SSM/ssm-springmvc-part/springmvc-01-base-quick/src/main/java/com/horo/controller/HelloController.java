package com.horo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HelloController
 * @Author iove
 * @Date 2024/10/14 上午11:32
 * @Version 1.0
 * @Description TODO
 **/
@RequestMapping("/springmvc")
@Controller
public class HelloController {
    @RequestMapping
    @ResponseBody
    public String HelloControllerBefore(){
        return "Hello World";
    }

    @RequestMapping("/hello")//向handlerMapping中添加这个handler方法的地址
    @ResponseBody//将java返回数据打包为json数据并返回，不要找视图解析器
    public String HelloController() {
        System.out.println("HelloController");
        return "hello springMVC!";
    }
}

package com.horo.controller;

import com.horo.pojo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Author iove
 * @Date 2024/10/18 下午3:03
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/data1")
    public String data() {
        //空指针异常NullPointerException
        String name=null;
        System.out.println("user data");
        //name.toString();
        return "ok";
    }
    @GetMapping("/data2")
    public String data2() {
        System.out.println("user data2");
        //算术异常ArithmeticException
        //int i=1/0;
        return "ok";
    }

    /**
     * 实现参数校验的方法
     * @return
     */
    @PostMapping("/data3")
    public Object data3(@Validated @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            Map data=new HashMap();
            data.put("code",400);
            data.put("msg","参数校验异常");
            return data;
        }

        System.out.println("user"+user);
        return user.toString();
    }
}

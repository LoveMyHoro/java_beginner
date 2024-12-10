package com.horo.param;

import com.horo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName ParamController
 * @Author iove
 * @Date 2024/10/14 下午9:37
 * @Version 1.0
 * @Description TODO
 **/
@Controller
@ResponseBody
@RequestMapping("param")
public class ParamController {
    @RequestMapping("")
    public String data() {
        System.out.println("hello springmvc");
        return "hello springmvc";
    }
     //1.直接接收参数
    //具体知识点见帮助文档
    @RequestMapping("/data1")
    public String data1(String username,Integer age) {
        System.out.println("username:"+username+",age:"+age);
        return "username:"+username+",age:"+age;
    }
    //2.利用注解接收参数
    @RequestMapping("/data2")
    public String data2(@RequestParam(value = "account") String username,
                        @RequestParam(required = false,defaultValue = "12") Integer age) {
        System.out.println("username:"+username+",age:"+age);
        return "username:"+username+",age:"+age;
    }
    //3.特殊值接值：一名多值
    @RequestMapping("/data3")
    public String data3(@RequestParam List<String>username) {
        System.out.println("username:"+username);
        return "ok";
    }
    //4.实体类接值
    @RequestMapping("/data4")
    public String data4(User user) {
        System.out.println("user:"+user);
        return user.toString();
    }
}

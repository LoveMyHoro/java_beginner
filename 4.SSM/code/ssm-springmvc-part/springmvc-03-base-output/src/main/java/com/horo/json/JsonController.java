package com.horo.json;

import com.horo.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName JsonConfig
 * @Author iove
 * @Date 2024/10/16 下午7:57
 * @Version 1.0
 * @Description TODO
 **/
//@Controller
@RequestMapping("json")
//@ResponseBody
@RestController//@RestController注解相当于@Controller注解+@ResponseBody注解
public class JsonController {
    //@ResponseBody：前后端分离，直接返回的是json数据
    @RequestMapping("data")
    public User data() {
        User user = new User();
        user.setName("Asuka");
        user.setAge(18);
        return user;
    }
}

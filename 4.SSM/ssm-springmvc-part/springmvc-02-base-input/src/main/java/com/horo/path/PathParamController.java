package com.horo.path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName PathParamController
 * @Author iove
 * @Date 2024/10/14 下午11:07
 * @Version 1.0
 * @Description TODO
 **/
@Controller
@RequestMapping("path")
@ResponseBody
public class PathParamController {
    @RequestMapping("{account}/{password}")
    //路径传参
    public String pathParam(@PathVariable("account") String account, @PathVariable("password") String password) {
        System.out.println("path param account: " + account + " password: " + password);
        return "success";
    }
}

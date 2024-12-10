package com.horo.controller;

import com.alibaba.druid.util.StringUtils;
import com.horo.pojo.User;
import com.horo.service.UserService;
import com.horo.utils.JwtHelper;
import com.horo.utils.Result;
import com.horo.utils.ResultCodeEnum;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserCOntroller
 * @Author iove
 * @Date 2024/10/28 下午5:11
 * @Version 1.0
 * @Description TODO 用户消息相关的controller
 **/
@RestController
@RequestMapping("/user")
@CrossOrigin//跨域
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper jwtHelper;

    /**
     * 1.1登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    //接收的是json数据
    public Result login(@RequestBody User user) {
        Result result=userService.login(user);
        System.out.println("登录状态码="+result.getCode());
        return result;
    }

    /**
     * 1.2.根据token获取用户数据
     * @param token
     * @return
     */
    @GetMapping("/getUserInfo")
    //接收的是请求头中的数据
    public Result getUserInfo(@RequestHeader String token) {
        Result result=userService.getUserInfo(token);
        System.out.println("登录状态码="+result.getCode());
        return result;
    }

    /**
     * 1.3.注册用户名检查
     * @param username
     * @return
     */
    @PostMapping("/checkUserName")
    public Result checkUserName(String username) {
        Result result=userService.checkUserName(username);
        return result;
    }

    /**
     * 1.4注册功能实现
     * @param user
     * @return
     */
    @PostMapping("/regist")
    public Result register(@RequestBody User user) {
        System.out.println("开启注册功能，用户名="+user.getUsername());
        Result result=userService.register(user);
        return result;
    }

    /**
     * 1.5登陆验证和保护
     * @return
     */
    @GetMapping("/checkLogin")
    public Result checkLogin(@RequestHeader String token) {
        System.out.println("检查token,判断是否登录或者登录是否过期");
        if(StringUtils.isEmpty(token)||jwtHelper.isExpiration(token)){
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }
        return Result.ok(null);
    }


}

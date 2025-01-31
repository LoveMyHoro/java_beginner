package com.horo.controller;

import com.horo.pojo.User;
import com.horo.service.UserService;
import com.horo.utils.JwtHelper;
import com.horo.utils.Result;
import com.horo.utils.ThreadLocalUtil;
import com.horo.vo.UpdatePwdVo;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Author iove
 * @Date 2024/11/1 下午4:05
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("/user")
@Validated//参数校验注解
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 1.注册
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "[^\s]{5,16}") String username, @Pattern(regexp = "[^/s]{5,16}")String password) {
        System.out.println("用户注册");
        Result result=userService.register(username,password);
        return result;
    }

    /**
     * 2.登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Result login(@Pattern(regexp = "[^\s]{5,16}")String username, @Pattern(regexp = "[^\s]{5,16}")String password) {
        System.out.println("username="+username+",password="+password);
        System.out.println("用户登录");
        Result result=userService.login(username,password);
        return result;
    }

    /**
     * 3.获取用户详细信息
     * @param
     * @return
     */
    @GetMapping("/userinfo")//由于可以从ThreadLocal里获取id,所以这里不需要接收token
    public Result userinfo() {
        System.out.println("获取用户详细信息");
        Result result=userService.getUserInfo();
        return result;
    }

    /**
     * 4.更新用户
     * @param user
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user) {
        if(user.getId()!= ThreadLocalUtil.get()){
            return Result.error("id有误");
        }
        System.out.println("更新用户信息");
        Result result=userService.updateByUser(user);
        return result;
    }

    /**
     * 5.更新用户头像
     * @param avatarUrl
     * @return
     */
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        Result result=userService.updateAvatar(avatarUrl);
        return result;
    }

    /**
     * 6.更新用户密码
     * @param updatePwdVo
     * @return
     */
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody UpdatePwdVo updatePwdVo,@RequestHeader String token) {
        System.out.println("更新密码");
        Result result=userService.updatePwd(updatePwdVo);
        //移除redis中的旧的token
        stringRedisTemplate.opsForValue().getOperations().delete(token);
        return result;
    }

}

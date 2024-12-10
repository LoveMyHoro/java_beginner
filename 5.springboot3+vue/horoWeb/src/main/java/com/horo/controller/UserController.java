package com.horo.controller;

import com.horo.pojo.User;
import com.horo.service.UserService;
import com.horo.utils.MailUtils;
import com.horo.utils.Result;
import com.horo.utils.ThreadLocalUtil;
import com.horo.vo.UpdatePwdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;



/**
 * @ClassName UserContriller
 * @Author iove
 * @Date 2024/11/11 上午10:26
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 1.注册业务
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        System.out.println("用户注册："+user);
        Result result=userService.register(user);
        return result;
    }

    /**
     * 2.登录业务
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        System.out.println("用户登录");
        Result result=userService.login(user);
        System.out.println(result.getData());
        return result;
    }

    /**
     * 3.获取用户详情
     * @return
     */
    @GetMapping("/getUserInfo")
    public Result getUserInfo() {
        int id=ThreadLocalUtil.get();
        Result result=userService.getUserInfo(id);
        return result;
    }

    /**
     * 4.更新用户密码
     * @param updatePwdVo
     * @return
     */
    @PostMapping("updatePwd")
    public Result update(@RequestBody UpdatePwdVo updatePwdVo) {
        Result result=userService.updatePwd(updatePwdVo);
        return result;
    }
    @PostMapping("/sendMail")
    public Result mail(String email) {
        System.out.println("邮件发送！to："+email);
        Result result=userService.sendMaill(email);
        return result;
    }

}

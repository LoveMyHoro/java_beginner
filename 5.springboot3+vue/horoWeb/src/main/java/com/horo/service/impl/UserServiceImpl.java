package com.horo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.horo.pojo.User;
import com.horo.service.UserService;
import com.horo.mapper.UserMapper;
import com.horo.utils.*;
import com.horo.vo.UpdatePwdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
* @author iove
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-11 10:23:09
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    JwtHelper jwtHelper = new JwtHelper();
    @Override
    public Result register(User user) {
        User byName = userMapper.findByName(user.getUsername());
        if (byName != null) {
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        userMapper.insert(user);
        return Result.ok(null);
    }

    @Override
    public Result login(User user) {
        User loginUser=userMapper.findByName(user.getUsername());
        if(loginUser==null){
            return Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }
        if(!loginUser.getPassword().equals(user.getPassword())){
            return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
        }
        System.out.println("loginUser="+loginUser);
        String token=jwtHelper.createToken(Long.valueOf(loginUser.getId()));
        Map <String,String>userInfo=new HashMap<>();
        userInfo.put("token",token);
        userInfo.put("id",loginUser.getId().toString());
        userInfo.put("username",loginUser.getUsername());
        userInfo.put("email",loginUser.getEmail());
        return Result.ok(userInfo);
    }

    @Override
    public Result getUserInfo(int id) {
        User user=userMapper.selectById(id);
        System.out.println("use="+user.toString());
        return Result.ok(user);
    }

    @Override
    public Result updatePwd(UpdatePwdVo updatePwdVo) {
        Integer id= ThreadLocalUtil.get();
        User user=userMapper.selectById(id);
        if(updatePwdVo.getOldPassword()==null||updatePwdVo.getNewPassword()==null||updatePwdVo.getConfirmPassword()==null){
            return Result.error("缺失必要参数");
        }
        if(!user.getPassword().equals(updatePwdVo.getOldPassword())){
            return Result.error("原密码输入有误");
        }
        if(!updatePwdVo.getNewPassword().equals(updatePwdVo.getConfirmPassword())){
            return Result.error("两次输入密码不一致");
        }
        int rows=userMapper.updatePwd(id,updatePwdVo.getNewPassword());
        System.out.println("密码修改成功，新密码为："+updatePwdVo.getNewPassword());
        return Result.success("密码修改成功！");
    }
    private static final SecureRandom random = new SecureRandom();
    @Override
    public Result sendMaill(String mail) {
        String VerificationCode="";
        for(int i=0;i<6;i++){
            VerificationCode+=random.nextInt(10);
        }
        String title="爱来自伟大的贤狼Horo";
        String text="您的验证码是："+VerificationCode+",请在5分钟内输入验证码以完成操作。";
        MailUtils.sendMail(mail,text,title);
        return Result.ok(VerificationCode);
    }
}





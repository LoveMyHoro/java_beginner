package com.horo.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.horo.pojo.User;
import com.horo.service.UserService;
import com.horo.mapper.UserMapper;
import com.horo.utils.JwtHelper;
import com.horo.utils.MD5Util;
import com.horo.utils.Result;
import com.horo.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author iove
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2024-10-28 11:13:15
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtHelper jwtHelper;
    /**
     * 1.登录业务
     * (1)返回值为Result类型数据
     * @param user
     * @return 校验用户名和密码并返回token
     */
    @Override
    public Result login(User user) {
        //LambdaQueryWrapper用于灵活构建查询条件
        LambdaQueryWrapper <User> wrapper = new LambdaQueryWrapper <>();
        wrapper.eq(User::getUsername,user.getUsername());
        //将wrapper放入userMapper进行数据库查询
        User loginUser = userMapper.selectOne(wrapper);

        if(loginUser==null){
            return Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }
        //判断密码非空并把密码加密后和数据库的密码比较
        if(!StringUtils.isEmpty(user.getUserPwd())&&MD5Util.encrypt(user.getUserPwd()).equals(loginUser.getUserPwd())){
            //利用用户的uuid构建token码并返回
            String token=jwtHelper.createToken(Long.valueOf(loginUser.getUid()));
            System.out.println("登录token码="+token);
            Map data=new HashMap();
            data.put("token",token);
            return Result.ok(data);
        }
        return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
    }
    /**
     * 1.2.根据token获取用户数据
     * @param token
     * @return
     */
    @Override
    public Result getUserInfo(String token) {
        //
        System.out.println("校验token码="+token);
        //判断token码是否过期
        if(jwtHelper.isExpiration(token)){
            return Result.build(null,ResultCodeEnum.NOTLOGIN);
        }
        //利用token码获取uuid
        int userId=jwtHelper.getUserId(token).intValue();
        System.out.println("userId="+userId);
        User user=userMapper.selectById(userId);
        if(user!=null){
            Map data=new HashMap();
            user.setUserPwd("");
            data.put("loginUser",user);
            return Result.ok(data);
        }
        return Result.build(null,ResultCodeEnum.NOTLOGIN);
    }

    @Override
    public Result checkUserName(String username) {
        LambdaQueryWrapper <User> wrapper = new LambdaQueryWrapper <>();
        wrapper.eq(User::getUsername,username);
        Long count = userMapper.selectCount(wrapper);
        if(count!=0){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        return Result.ok(null);
    }

    @Override
    public Result register(User user) {
        //这一段和上面一样，都是校验用户名
        LambdaQueryWrapper <User> wrapper = new LambdaQueryWrapper <>();
        wrapper.eq(User::getUsername,user.getUsername());
        Long count = userMapper.selectCount(wrapper);
        if(count!=0){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        //加密密码，然后插入数据库
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        userMapper.insert(user);
        System.out.println("注册成功！");
        return Result.ok(null);
    }
}





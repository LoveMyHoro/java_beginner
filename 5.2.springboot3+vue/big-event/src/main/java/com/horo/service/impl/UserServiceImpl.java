package com.horo.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.horo.pojo.User;
import com.horo.service.UserService;
import com.horo.mapper.UserMapper;
import com.horo.utils.*;
import com.horo.vo.UpdatePwdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author iove
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-11-01 15:07:00
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<User> findAll() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    @Override
    public Result register(String username, String password) {
        //检查用户是否已经被占用
        LambdaQueryWrapper<User>queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(User::getUsername,username);
        if(userMapper.selectCount(queryWrapper)>0){
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(Md5Util.getMD5String(password));
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int rows = userMapper.insert(user);
        return Result.ok(null);
    }

    @Override
    public Result login(String username,String password){
        LambdaQueryWrapper <User>queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(User::getUsername,username);
        User user = userMapper.selectOne(queryWrapper);
        if(user==null){
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        if(!StringUtils.isEmpty(password)&&Md5Util.getMD5String(password).equals(user.getPassword())){
            String token = jwtHelper.createToken(Long.valueOf(user.getId()));
            System.out.println("登陆成功");
            System.out.println("token="+token);
            //将token放入redis中
            stringRedisTemplate.opsForValue().set(token,token);
            return Result.ok(token);
        }
        return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getUserInfo() {
        int id = ThreadLocalUtil.get();
        System.out.println("ThreadLocal包含id="+id);
        User user = userMapper.selectById(id);
        return Result.ok(user);
    }

    @Override
    public Result updateByUser(User user) {
        user.setUpdateTime(new Date());
        userMapper.updateByUser(user);
        return Result.ok(null);
    }

    @Override
    public Result updatePwd(UpdatePwdVo updatePwdVo) {
        Integer id = ThreadLocalUtil.get();
        User user = userMapper.selectById(id);
        System.out.println(updatePwdVo);
        //1.判断密码不为空
        if(StringUtils.isEmpty(updatePwdVo.getOld_pwd())||StringUtils.isEmpty(updatePwdVo.getNew_pwd())||StringUtils.isEmpty(updatePwdVo.getRe_pwd())){
            return Result.error("缺少必要的参数");
        }
        //2.判断传过来的old_pwd是否正确
        if(!user.getPassword().equals(Md5Util.getMD5String(updatePwdVo.getOld_pwd()))){
            return Result.error("原密码填写不正确");
        }
        //3.判断new_pwd和re_pwd相同
        if(!updatePwdVo.getNew_pwd().equals(updatePwdVo.getRe_pwd())){
            return Result.error("两次填写密码不一致");
        }
        String newPwd = Md5Util.getMD5String(updatePwdVo.getNew_pwd());
        userMapper.updatePwd(newPwd,id);
        return Result.ok(null);
    }

    @Override
    public Result updateAvatar(String avatarUrl) {
        Integer id = ThreadLocalUtil.get();
        userMapper.updateAvatar(avatarUrl,id);
        return Result.ok(null);
    }

}





package com.horo.service;

import com.horo.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.horo.utils.Result;
import com.horo.vo.UpdatePwdVo;

import java.util.List;

/**
* @author iove
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-11-01 15:07:00
*/
public interface UserService extends IService<User> {

    List<User> findAll();

    Result register(String username, String password);

    Result login(String username, String password);

    Result getUserInfo();

    Result updateByUser(User user);

    Result updatePwd(UpdatePwdVo updatePwdVo);

    Result updateAvatar(String avatarUrl);
}

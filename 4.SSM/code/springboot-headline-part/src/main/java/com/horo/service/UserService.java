package com.horo.service;

import com.horo.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.horo.utils.Result;

/**
* @author iove
* @description 针对表【news_user】的数据库操作Service
* @createDate 2024-10-28 11:13:15
*/
public interface UserService extends IService<User> {

    Result login(User user);

    Result getUserInfo(String token);

    Result checkUserName(String username);

    Result register(User user);
}

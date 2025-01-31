package com.horo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.horo.pojo.User;
import com.horo.service.UserService;
import com.horo.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author iove
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-10-31 14:40:48
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}





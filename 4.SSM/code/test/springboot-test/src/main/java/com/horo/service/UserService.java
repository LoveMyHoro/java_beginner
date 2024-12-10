package com.horo.service;

import com.horo.mapper.UserMapper;
import com.horo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Author iove
 * @Date 2024/10/25 下午8:09
 * @Version 1.0
 * @Description TODO
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> findAll() {
        List<User> userList = userMapper.getUserList();
        return userList;
    }
}

package com.horo.service;

import com.horo.mapper.UserMapper;
import com.horo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Author iove
 * @Date 2024/10/27 下午6:45
 * @Version 1.0
 * @Description TODO
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> findAll() {
        List<User> users = userMapper.selectList(null);
        return users;
    }
}

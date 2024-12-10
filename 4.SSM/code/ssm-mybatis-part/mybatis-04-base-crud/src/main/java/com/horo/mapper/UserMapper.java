package com.horo.mapper;

import com.horo.pojo.User;

import java.util.List;

public interface UserMapper {
    int insert(User user);

    int delete(Integer id);

    int update(User user);

    User selectById(Integer id);

    List<User> selectAll();

}

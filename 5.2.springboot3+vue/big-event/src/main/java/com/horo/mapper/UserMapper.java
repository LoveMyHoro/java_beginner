package com.horo.mapper;

import com.horo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author iove
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2024-11-01 15:07:00
* @Entity com.horo.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    void updateByUser(User user);

    void updateAvatar(String avatarUrl,Integer id);

    void updatePwd(String newPwd, Integer id);
}





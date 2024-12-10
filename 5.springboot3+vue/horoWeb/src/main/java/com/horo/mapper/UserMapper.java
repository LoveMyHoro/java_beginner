package com.horo.mapper;

import com.horo.pojo.Articles;
import com.horo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author iove
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-11-17 19:40:13
* @Entity com.horo.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {



	User findByName(String username);

	int updatePwd(Integer id, String newPassword);
}





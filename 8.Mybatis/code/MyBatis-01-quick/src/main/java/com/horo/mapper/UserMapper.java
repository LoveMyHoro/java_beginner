package com.horo.mapper;

import com.horo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	int insertUser();

	int deleteUser();

	int updateUser();

	List<User> getAllUser();
	//利用map数据类型接收返回值
	List<Map<String, Object>> getAllUsersToMap();
	//模糊查询
	User getUserByLike(@Param("username") String username);
	//in 批量删除
	Integer deleteUserByIn(@Param("ids") String ids);
	//主键回显
	Integer insertUser(User user);
}

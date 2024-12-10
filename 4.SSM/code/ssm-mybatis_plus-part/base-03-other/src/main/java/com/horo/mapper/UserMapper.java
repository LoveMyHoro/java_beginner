package com.horo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.horo.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    //自定义的根据年龄的分页查询方法
    IPage<User> queryByAge(IPage<User>page,@Param("age") Integer age);



}

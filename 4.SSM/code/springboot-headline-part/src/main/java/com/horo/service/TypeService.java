package com.horo.service;

import com.horo.pojo.Type;
import com.baomidou.mybatisplus.extension.service.IService;
import com.horo.utils.Result;

/**
* @author iove
* @description 针对表【news_type】的数据库操作Service
* @createDate 2024-10-28 11:13:15
*/
public interface TypeService extends IService<Type> {

    Result findAllTypes();
}

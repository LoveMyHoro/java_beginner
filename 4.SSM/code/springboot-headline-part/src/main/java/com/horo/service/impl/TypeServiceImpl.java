package com.horo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.horo.pojo.Type;
import com.horo.service.TypeService;
import com.horo.mapper.TypeMapper;
import com.horo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author iove
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2024-10-28 11:13:15
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

    @Autowired
    private TypeMapper typeMapper;
    @Override
    public Result findAllTypes() {
        List<Type> types = typeMapper.selectList(null);
        return Result.ok(types);
    }
}





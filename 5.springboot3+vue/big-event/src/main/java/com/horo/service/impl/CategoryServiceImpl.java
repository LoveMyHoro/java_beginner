package com.horo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.horo.pojo.Category;
import com.horo.service.CategoryService;
import com.horo.mapper.CategoryMapper;
import com.horo.service.UserService;
import com.horo.utils.Result;
import com.horo.utils.ThreadLocalUtil;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author iove
* @description 针对表【category】的数据库操作Service实现
* @createDate 2024-11-01 15:07:00
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Result addCategory(Category category) {
        Integer createId=ThreadLocalUtil.get();
        category.setCreateUser(createId);
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        categoryMapper.insert(category);
        return Result.ok(null);
    }

    @Override
    public Result getAllCategory() {
        List<Category> categoryList=categoryMapper.selectList(null);
        return Result.ok(categoryList);
    }

    @Override
    public Result getCategoryDetail(Integer id) {
        Category category = categoryMapper.selectById(id);
        return Result.ok(category);
    }

    @Override
    public Result updateCategory(Category category) {
        category.setUpdateTime(new Date());
        categoryMapper.updateById(category);
        return Result.ok(null);
    }

    @Override
    public Result deleteCategory(Integer id) {
        categoryMapper.deleteById(id);
        return Result.ok(null);
    }
}





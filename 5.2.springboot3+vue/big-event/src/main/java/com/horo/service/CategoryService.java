package com.horo.service;

import com.horo.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.horo.utils.Result;

/**
* @author iove
* @description 针对表【category】的数据库操作Service
* @createDate 2024-11-01 15:07:00
*/
public interface CategoryService extends IService<Category> {

    Result addCategory(Category category);

    Result getAllCategory();

    Result getCategoryDetail(Integer id);

    Result updateCategory(Category category);

    Result deleteCategory(Integer id);
}

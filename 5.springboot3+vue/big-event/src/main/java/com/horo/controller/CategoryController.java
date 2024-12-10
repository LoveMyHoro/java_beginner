package com.horo.controller;

import com.horo.pojo.Category;
import com.horo.service.CategoryService;
import com.horo.utils.Result;
import com.horo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CategoryController
 * @Author iove
 * @Date 2024/11/2 上午12:19
 * @Version 1.0
 * @Description TODO
 **/
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/category")
    public Result addCategory(@RequestBody @Validated(Category.Add.class) Category category) {
        Result result=categoryService.addCategory(category);
        return result;
    }
    @GetMapping("/category")
    public Result getAllCategory() {
        System.out.println("token="+ThreadLocalUtil.get());
        Result result=categoryService.getAllCategory();
        return result;
    }
    @GetMapping("/category/detail")
    public Result getCategoryDetail(Integer id) {
        Result result=categoryService.getCategoryDetail(id);
        return result;
    }
    @PutMapping("/category")
    public Result updateCategory(@RequestBody @Validated(Category.Update.class) Category category) {
        Result result=categoryService.updateCategory(category);
        return result;
    }
    @DeleteMapping("/category")
    public Result deleteCategory(Integer id) {
        Result result=categoryService.deleteCategory(id);
        return result;
    }
}

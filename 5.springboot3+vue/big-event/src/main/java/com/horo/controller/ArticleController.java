package com.horo.controller;

import com.horo.pojo.Article;
import com.horo.service.ArticleService;
import com.horo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ArticleController
 * @Author iove
 * @Date 2024/11/4 上午10:48
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("/article")
@Validated
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping
    public Result addArticle(@RequestBody @Validated Article article) {
        Result result=articleService.addArticle(article);
        return result;
    }
    @GetMapping
    public Result getArticle(Integer pageNum, Integer pageSize,@RequestParam(required = false) Integer categoryId,@RequestParam(required = false) String state) {
        System.out.println("pageNum:"+pageNum);
        System.out.println("pageSize:"+pageSize);
        System.out.println("categoryId:"+categoryId);
        System.out.println("state:"+state);
        Result result=articleService.getArticle(pageNum,pageSize,categoryId,state);
        return result;
    }
    @GetMapping("/detail")
    public Result getArticleDetail(Integer id) {
        Result result=articleService.getArticleDetail(id);
        return result;
    }
    @PutMapping
    public Result updateArticle(@RequestBody @Validated Article article) {
        Result result=articleService.updateArticle(article);
        return result;
    }
    @DeleteMapping
    public Result deleteArticle(Integer id) {
        Result result=articleService.deleteArticle(id);
        return result;
    }
}

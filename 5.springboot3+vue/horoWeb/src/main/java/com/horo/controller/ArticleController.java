package com.horo.controller;

import com.horo.mapper.ArticlesMapper;
import com.horo.pojo.Articles;
import com.horo.service.ArticlesService;
import com.horo.utils.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName ArticleController
 * @Author iove
 * @Date 2024/11/12 下午5:20
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticlesService articlesService;
    @GetMapping("/getByPage")
    public Result getByPage(Integer pageNum, Integer pageSize, HttpServletRequest request){
        String token=request.getHeader("token");
        System.out.println("主页token="+token);
        System.out.println("pageNum="+pageNum+",pageSize="+pageSize);
        Result result = articlesService.getByPage(pageNum,pageSize);
        return result;
    }
    @GetMapping("/getById")
    public Result getById(Integer id){
        System.out.println("文章详情查询");
        Articles articles=articlesService.getById(id);
        System.out.println(articles);
        return Result.ok(articles);
    }
    @PostMapping("/addArticle")
    public Result addArticle(@RequestBody Articles articles){
        System.out.println("新增文章");
        Result result=articlesService.addArticle(articles);
        return result;
    }
    @GetMapping("/remove")
    public Result removeById(Integer id){
        Result result=articlesService.removeArticle(id);
        return result;
    }
    @GetMapping("/getCreaterId")
    public Result getCreaterId(Integer id){
        Result result=articlesService.getCreaterId(id);
        return result;
    }
    @PostMapping("updateArticle")
    public Result updateArticle(@RequestBody Articles articles){
        Result result=articlesService.updateArticle(articles);
        return result;
    }

}

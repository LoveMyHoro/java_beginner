package com.horo.service;

import com.horo.pojo.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.horo.utils.Result;

/**
* @author iove
* @description 针对表【article】的数据库操作Service
* @createDate 2024-11-01 15:07:00
*/
public interface ArticleService extends IService<Article> {

    Result addArticle(Article article);

    Result getArticle(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    Result getArticleDetail(Integer id);

    Result updateArticle(Article article);

    Result deleteArticle(Integer id);
}

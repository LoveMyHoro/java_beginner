package com.horo.mapper;

import com.horo.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author iove
* @description 针对表【article】的数据库操作Mapper
* @createDate 2024-11-01 15:07:00
* @Entity com.horo.pojo.Article
*/
public interface ArticleMapper extends BaseMapper<Article> {

    List<Article> getArticlePage(Integer uid, Integer categoryId, String state);

    Article getArticleDetail(Integer id);
}





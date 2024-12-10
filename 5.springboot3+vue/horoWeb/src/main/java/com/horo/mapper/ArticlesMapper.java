package com.horo.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.horo.pojo.Articles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author iove
* @description 针对表【articles】的数据库操作Mapper
* @createDate 2024-11-12 17:19:35
* @Entity com.horo.pojo.Articles
*/
public interface ArticlesMapper extends BaseMapper<Articles> {

    List<Articles> selectMyPage(Integer userId);

    void addArticle(Articles articles);

    void removeArticle(Integer id);

    Integer getCreaterId(Integer id);

	Integer updateArticle(Articles articles);
}





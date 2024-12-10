package com.horo.service;

import com.horo.pojo.Articles;
import com.baomidou.mybatisplus.extension.service.IService;
import com.horo.utils.Result;

/**
* @author iove
* @description 针对表【articles】的数据库操作Service
* @createDate 2024-11-12 17:19:35
*/
public interface ArticlesService extends IService<Articles> {


    Result getByPage(Integer pageNum, Integer pageSize);

	Result addArticle(Articles articles);

	Result removeArticle(Integer id);

	Result getCreaterId(Integer id);

	Result updateArticle(Articles articles);
}

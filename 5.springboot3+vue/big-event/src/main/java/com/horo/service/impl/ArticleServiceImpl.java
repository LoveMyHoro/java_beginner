package com.horo.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.horo.pojo.Article;
import com.horo.pojo.Category;
import com.horo.pojo.PageBean;
import com.horo.service.ArticleService;
import com.horo.mapper.ArticleMapper;
import com.horo.utils.Result;
import com.horo.utils.ThreadLocalUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author iove
* @description 针对表【article】的数据库操作Service实现
* @createDate 2024-11-01 15:07:00
*/
@Service
@Log4j2
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public Result addArticle(Article article) {
        Integer id=ThreadLocalUtil.get();
        article.setCreateUser(id);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        articleMapper.insert(article);
        return Result.ok(null);
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @param state
     * @return
     */
    @Override
    public Result getArticle(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        PageBean pageBean=new PageBean();
        PageHelper.startPage(pageNum,pageSize);

        Integer uid=ThreadLocalUtil.get();
        //将返回的数据类型强制转换为Page类型
        Page<Article> page =(Page<Article>) articleMapper.getArticlePage(uid,categoryId,state);

        pageBean.setTotal(page.getTotal());
        pageBean.setItems(page.getResult());
        return Result.ok(pageBean);
    }

    @Override
    public Result getArticleDetail(Integer id) {
        Article article=articleMapper.getArticleDetail(id);
        return Result.ok(article);
    }

    @Override
    public Result updateArticle(Article article) {
        articleMapper.updateById(article);
        return Result.ok(null);
    }

    @Override
    public Result deleteArticle(Integer id) {
        articleMapper.deleteById(id);
        return Result.ok(null);
    }
}





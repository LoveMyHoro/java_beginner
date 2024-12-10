package com.horo.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.horo.mapper.UserMapper;
import com.horo.pojo.Articles;
import com.horo.pojo.PageBean;
import com.horo.pojo.User;
import com.horo.service.ArticlesService;
import com.horo.mapper.ArticlesMapper;
import com.horo.utils.Result;
import com.horo.utils.ThreadLocalUtil;
import io.netty.handler.ipfilter.IpFilterRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author iove
* @description 针对表【articles】的数据库操作Service实现
* @createDate 2024-11-12 17:19:35
*/
@Service
public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, Articles>
    implements ArticlesService{
    @Autowired
    private ArticlesMapper articlesMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public Result getByPage(Integer pageNum, Integer pageSize) {
        Integer userId= ThreadLocalUtil.get();
        PageBean pageBean=new PageBean();
        PageHelper.startPage(pageNum,pageSize);
        Page<Articles> page=(Page<Articles>) articlesMapper.selectMyPage(userId);
        pageBean.setTotal(page.getTotal());
        pageBean.setArticles(page.getResult());
        return Result.ok(pageBean);
    }

    @Override
    public Result addArticle(Articles articles) {
        Integer userId=ThreadLocalUtil.get();
        User user=userMapper.selectById(userId);
        articles.setUserId(userId);
        articles.setUserName(user.getUsername());
        System.out.println("新增文章:"+articles);
        articlesMapper.addArticle(articles);
        return  Result.ok(null);
    }

    @Override
    public Result removeArticle(Integer id) {
        Integer createrId=articlesMapper.getCreaterId(id);
        if(createrId==0){
            return Result.error("该文章无删除权限！");
        }
        articlesMapper.removeArticle(id);
        return Result.ok(null);
    }

    @Override
    public Result getCreaterId(Integer id) {
        Integer userId=articlesMapper.getCreaterId(id);
        return Result.ok(userId);
    }

    @Override
    public Result updateArticle(Articles articles) {
        articlesMapper.updateArticle(articles);
        return Result.ok(null);
    }
}





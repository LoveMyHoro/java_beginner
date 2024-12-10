package com.horo.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.horo.pojo.Headline;
import com.horo.pojo.User;
import com.horo.service.HeadlineService;
import com.horo.mapper.HeadlineMapper;
import com.horo.utils.JwtHelper;
import com.horo.utils.Result;
import com.horo.utils.ResultCodeEnum;
import com.horo.vo.PortalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author iove
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2024-10-28 11:13:15
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{
    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private HeadlineMapper headlineMapper;
    /**
     * 1.分页查询首页头条信息
     * @param portalVo
     * @return
     */
    @Override
    public Result findNewsPage(PortalVo portalVo) {
        //Ipag相当于集合,专门用来接收分页查询的数据
        IPage page=new Page(portalVo.getPageNum(),portalVo.getPageSize());
        headlineMapper.selectMyPage(page,portalVo);
        //利用map集合来接page里的内容
        List<Map>records=page.getRecords();
        Map data =new HashMap();
        data.put("pageData",records);
        data.put("pageNum",page.getCurrent());
        data.put("pageSize",page.getSize());
        data.put("totalPage",page.getPages());
        data.put("totalSize",page.getTotal());

        Map pageInfo=new HashMap();
        pageInfo.put("pageInfo",data);
        return Result.ok(pageInfo);
    }

    /**
     * 查询头条详情
     * @param hid
     * @return
     */
    @Override
    public Result showHeadlineDetail(Integer hid) {
        //1.实现根据id的查询(多表
        Map headLineDetail=headlineMapper.selectDetailMap(hid);
        //2.拼接头条对象(阅读量和version)进行数据更新
        Headline headline=new Headline();
        headline.setHid(hid);
        headline.setPageViews((Integer) headLineDetail.get("pageViews")+1); //阅读量+1
        headline.setVersion((Integer) headLineDetail.get("version")); //设置版本

        //3.将更新后的headLineDetail更新到数据库中，因为回到主界面后会刷新界面，阅读量和version就会更新
        headlineMapper.updateById(headline);

        //4.返回查询到的数据
        Map<String,Object> pageInfo=new HashMap();
        pageInfo.put("headline",headLineDetail);
        return Result.ok(pageInfo);

    }

    @Override
    public Result publish(Headline headline, String token) {
        //可以设置拦截器，只有token有效时，才能插入数据
        headline.setPublisher(jwtHelper.getUserId(token).intValue());
        headline.setPageViews(0);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());
        headlineMapper.insert(headline);
        System.out.println(headline);
        return Result.ok(null);
    }



    @Override
    public Result findHeadlineByHid(Integer hid) {
        Headline headline=headlineMapper.selectOne(new QueryWrapper<Headline>().eq("hid", hid));
        System.out.println("uid="+hid+",headline:"+headline);
        Map data=new HashMap();
        data.put("headline",headline);
        return Result.ok(data);
    }

    @Override
    public Result updateHeadLine(Headline headline) {
        Integer version = headlineMapper.selectById(headline.getHid()).getVersion();
        headline.setVersion(version+1);
        headline.setUpdateTime(new Date());
        headlineMapper.updateById(headline);
        return Result.ok(null);
    }


}





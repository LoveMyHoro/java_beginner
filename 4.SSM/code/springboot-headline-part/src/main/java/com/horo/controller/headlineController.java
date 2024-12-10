package com.horo.controller;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import com.horo.mapper.HeadlineMapper;
import com.horo.pojo.Headline;
import com.horo.service.HeadlineService;
import com.horo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName headlineController
 * @Author iove
 * @Date 2024/10/29 下午10:29
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("/headline")
@CrossOrigin
public class headlineController {
    @Autowired
    private HeadlineService headlineService;

    /**
     * 1.头条发布实现
     * @param headline
     * @param token
     * @return
     */
    @PostMapping("/publish")
    public Result publish(@RequestBody Headline headline,@RequestHeader String token) {
        System.out.println("后端将新闻信息存入数据库");
        Result result=headlineService.publish(headline,token);
        return result;
    }

    /**
     * 2.修改头条回显
     * @param hid
     * @return
     */
    @PostMapping("/findHeadlineByHid")
    public Result findHeadlineByHid(Integer hid) {
        System.out.println("hid:"+hid);
        Result result=headlineService.findHeadlineByHid(hid);
        return result;
    }

    /**
     * 3.修改数据
     * @param headline
     * @return
     */
    @PostMapping("/update")
    public Result updateHeadLine(@RequestBody Headline headline) {
        Result result=headlineService.updateHeadLine(headline);
        return result;
    }

    /**
     * 4.删除数据
     * @param hid
     * @return
     */
    @PostMapping("/removeByHid")
    public Result deleteHeadLine(Integer hid) {
        //由于删除逻辑很简单，所以这里就直接使用headlineService中的数据库方法
        //这里的删除都是逻辑删除，即deleted=1
        System.out.println("开始数据删除");
        headlineService.removeById(hid);
        return Result.ok(null);
    }
}

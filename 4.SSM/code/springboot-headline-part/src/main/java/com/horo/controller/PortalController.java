package com.horo.controller;

import com.horo.pojo.Type;
import com.horo.service.HeadlineService;
import com.horo.service.TypeService;
import com.horo.service.UserService;
import com.horo.service.impl.HeadlineServiceImpl;
import com.horo.utils.Result;
import com.horo.vo.PortalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName PortalController
 * @Author iove
 * @Date 2024/10/28 下午9:43
 * @Version 1.0
 * @Description TODO 这是首页查询相关的controller
 **/
@RestController
@RequestMapping("/portal")
@CrossOrigin
public class PortalController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private HeadlineService headlineService;

    /**
     * 1.查询首页分类
     * @return
     */
    @GetMapping("/findAllTypes")
    public Result findAllTypes() {
        System.out.println("/findAllTypes");
        Result result=typeService.findAllTypes();
        return result;
    }

    /**
     * 2.分页查询首页头条信息
     * @param portalVo
     * @return
     */
    @PostMapping("/findNewsPage")
    public Result findNewsPage(@RequestBody PortalVo portalVo) {
        System.out.println(portalVo.toString());
        Result result= headlineService.findNewsPage(portalVo);
        return result;
    }

    @PostMapping("/showHeadlineDetail")
    public Result showHeadlineDetail(Integer hid) {
        Result result=headlineService.showHeadlineDetail(hid);
        return result;
    }


}

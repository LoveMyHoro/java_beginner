package com.horo.service;

import com.horo.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import com.horo.utils.Result;
import com.horo.vo.PortalVo;

/**
* @author iove
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-10-28 11:13:15
*/
public interface HeadlineService extends IService<Headline> {

    Result findNewsPage(PortalVo portalVo);

    Result showHeadlineDetail(Integer hid);

    Result publish(Headline headline, String token);

    Result findHeadlineByHid(Integer hid);

    Result updateHeadLine(Headline headline);
}

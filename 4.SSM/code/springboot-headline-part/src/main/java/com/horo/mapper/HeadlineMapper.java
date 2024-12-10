package com.horo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.horo.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.horo.utils.Result;
import com.horo.vo.PortalVo;

import java.util.Map;

/**
* @author iove
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2024-10-28 11:13:15
* @Entity com.horo.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {
    IPage<Map> selectMyPage(IPage<Map> page, PortalVo portalVo);

    Map selectDetailMap(Integer hid);

}





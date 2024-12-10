package com.horo.vo;

import lombok.Data;

/**
 * @ClassName PortalVo
 * @Author iove
 * @Date 2024/10/28 下午10:19
 * @Version 1.0
 * @Description TODO
 **/
@Data
public class PortalVo {
    private String keyWords;
    private Integer type=0;
    private Integer pageNum=1;
    private Integer pageSize=10;
}

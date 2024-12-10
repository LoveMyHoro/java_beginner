package com.horo.pojo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName PageBean
 * @Author iove
 * @Date 2024/11/12 下午7:29
 * @Version 1.0
 * @Description TODO 这个实体类用于分页查询
 **/
@Data
public class PageBean <T>{
    private Long total;
    private List<T>articles;
}

package com.horo.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    //标识逻辑删除字段
    @TableLogic
    private Integer deleted;
}
package com.horo.pojo;

import lombok.Data;

/**
 * @ClassName User
 * @Author iove
 * @Date 2024/10/27 下午5:17
 * @Version 1.0
 * @Description TODO
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

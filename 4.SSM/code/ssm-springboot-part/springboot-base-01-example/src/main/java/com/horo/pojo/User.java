package com.horo.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName User
 * @Author iove
 * @Date 2024/10/25 上午9:36
 * @Version 1.0
 * @Description TODO
 **/
@Data
@Component
@ConfigurationProperties(prefix = "user")
/**
 *@ConfigurationProperties ：批量读取application配置的属性，prefix=要读取的类中数据的上一层标签，比如这里就是"user"
 * 因为@value注解无法读取集合数据，所以这里不使用@value读取单个数据
 * 要求：
 *  （1）要求实体类的属性值=最后一层key的值
 * 优势：
 *  （1）方便，不用可以批量读取
 *  （2）可以给集合数据赋值
 */
public class User {
    private String name;
    private int age;
    private List<String>gfs;
    private String path;
}

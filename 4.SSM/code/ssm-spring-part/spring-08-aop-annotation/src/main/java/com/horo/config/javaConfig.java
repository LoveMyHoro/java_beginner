package com.horo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName javaConfig
 * @Author iove
 * @Date 2024/10/5 下午3:19
 * @Version 1.0
 * @Description TODO
 **/
@Configuration
@ComponentScan(value = "com.horo")
@EnableAspectJAutoProxy//开启aspect的注解支持
public class javaConfig {



}

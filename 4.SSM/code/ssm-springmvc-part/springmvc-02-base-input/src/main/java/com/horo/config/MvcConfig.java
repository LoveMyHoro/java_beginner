package com.horo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @ClassName MvcConfig
 * @Author iove
 * @Date 2024/10/14 上午11:40
 * @Version 1.0
 * @Description TODO 1.controller配置ioc容器
 *                   2.handlerMapping handlerAdapter加入到容器
 **/
//@EnableWebMvc这个标签不仅会为配置类添加json处理器，
//还可以向ioc容器在加入HandlerMapping(秘书)和HandlerAdapter(经理)，所以原先的两个方法可以注释掉
@EnableWebMvc
@Configuration
@ComponentScan("com.horo")
public class MvcConfig {

    /*@Bean
    //创建handlerMapping放入ioc容器，这个用来配置地址映射
    public RequestMappingHandlerMapping handlerMapping() {
        return new RequestMappingHandlerMapping();
    }
    @Bean
    //创建HandlerAdapter放入ioc容器，这个用来与前端进行数据交换
    public RequestMappingHandlerAdapter HandlerAdapter(){
        return new RequestMappingHandlerAdapter();
    }*/
}

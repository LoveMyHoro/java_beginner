package com.horo.config;

import com.horo.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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
@Configuration
@ComponentScan("com.horo")
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    /**
     * 开启静态资源处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置方案1：拦截全部请求
        //registry.addInterceptor(new MyInterceptor());
        //配置方案2:指定地址拦截
        //registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user2/data1");
        //配置方案3:指定地址不拦截
        registry.addInterceptor(new MyInterceptor()).excludePathPatterns("user/data1");
    }
}

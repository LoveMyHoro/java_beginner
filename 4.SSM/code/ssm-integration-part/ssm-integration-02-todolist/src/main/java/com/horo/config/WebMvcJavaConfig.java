package com.horo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @ClassName WebMvcJavaConfig
 * @Author iove
 * @Date 2024/10/21 下午8:25
 * @Version 1.0
 * @Description TODO 这个是springMvc的配置类(也是Controller层的配置类)
 *
 * 主要配置的有：
 *  1.controller
 *  2.全局异常处理器
 *  3.handlerMapping,handlerAdapter
 *  4.静态资源处理器
 *  5.jsp视图解析器前后缀
 *  6.json转化器
 *  7.拦截器
 **/
@Configuration
@ComponentScan("com.horo")//扫描包，包括1.controller，2.全局异常处理器
@EnableWebMvc//配置3.handlerMapping,handlerAdapter和6.json转化器
public class WebMvcJavaConfig implements WebMvcConfigurer {//WebMvcConfigurer接口中提供了许多方便的配置方法


    @Override//配置了4.静态资源处理器
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override//配置了5.jsp视图解析器前后缀
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }

    @Override//配置了7.拦截器
    public void addInterceptors(InterceptorRegistry registry) {

    }
}

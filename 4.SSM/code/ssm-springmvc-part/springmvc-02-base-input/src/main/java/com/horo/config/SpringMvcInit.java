package com.horo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @ClassName SpringMvcInit
 * @Author iove
 * @Date 2024/10/14 上午11:51
 * @Version 1.0
 * @Description TODO
 **/

public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //service,mapper层的ioc容器配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //加载配置类，创建ioc容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }
    //配置springMVC内部自带的servlet的访问地址
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

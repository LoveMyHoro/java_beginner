package com.horo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @ClassName SpringIoInit
 * @Author iove
 * @Date 2024/10/22 下午10:49
 * @Version 1.0
 * @Description TODO 这个类spring的初始化类，将配置类分别装入两个容器
 **/

public class SpringIoInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override//这个方法用于向Root容器装入配置类
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataSourceJavaConfig.class, MapperJavaConfig.class, ServiceJavaConfig.class};
    }

    @Override//这个方法用于向Servlet容器装入配置类
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcJavaConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

package com.horo.ioc_02_组件作用域和周期方法注解;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component
//设置该类为多例模式
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class JavaBean {
    /**
     * 添加此注解后，这个方法在容器创建时会被调用
     */
    @PostConstruct
    public void init(){
        System.out.println("init");
    }
    /**
     * 添加此注解后，这个方法在容器销毁时会被调用
     */
    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }
}

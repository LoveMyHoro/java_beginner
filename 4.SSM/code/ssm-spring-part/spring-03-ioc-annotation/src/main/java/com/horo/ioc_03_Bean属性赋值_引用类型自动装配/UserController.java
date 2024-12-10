package com.horo.ioc_03_Bean属性赋值_引用类型自动装配;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

    //1.自动装配注解(DI)：(1).在ioc容器中查找符合类型的组件对象 (2).设置当前属性(di)
    //前提是作为参数的组件存在于容器中。
    @Autowired
    //2.Qualifier的作用是当出现不止一个与@Autowired匹配的bean时会选择id与Qualifier的value的值相同的bean
    @Qualifier(value = "userServiceImpl")
    private UserServiceImpl userService;

    //3.Resource注解的作用相当于Autowired注解+Qualifier注解
    //不过在使用Resource之前要先导入相关依赖
    @Resource(name = "userServiceImpl")
    private UserServiceImpl userService2;

    public void show(){
        System.out.println(userService.show());
    }
}

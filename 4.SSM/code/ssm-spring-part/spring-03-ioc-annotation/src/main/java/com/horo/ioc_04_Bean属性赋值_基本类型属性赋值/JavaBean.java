package com.horo.ioc_04_Bean属性赋值_基本类型属性赋值;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaBean {
    //@value注解通常要搭配配置文件一起使用，此配置文件中包含的一般都是各种参数值
    //也可以在@value注解里面加上默认值,admin.username:horo冒号后面的horo就是默认值
    //当admin.username不存在时，就会使用默认值
    @Value("${admin.username:horo}")
    private String username;
    @Value("${admin.password}")
    private String password;

    @Override
    public String toString() {
        return "JavaBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

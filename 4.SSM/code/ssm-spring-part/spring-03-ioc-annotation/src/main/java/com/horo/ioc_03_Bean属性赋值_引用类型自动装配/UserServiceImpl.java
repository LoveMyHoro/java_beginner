package com.horo.ioc_03_Bean属性赋值_引用类型自动装配;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Override
    public String show() {
        return "UserServiceImpl show()";
    }
}

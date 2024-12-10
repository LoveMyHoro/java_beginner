package com.horo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//标识启动类，用于启动springboot项目
/*
*@SpringBootApplication作用：
* （1）配置类
* （2）自动加载配置
* （3）扫描当前类所在的包以及子包
*/

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);//自动创建ioc容器，启动tomcat服务器
        /*
         *SpringApplication.run作用：
         * 1.创建ioc容器，加载配置
         * 2.启动内置的web服务器
         */
    }
}
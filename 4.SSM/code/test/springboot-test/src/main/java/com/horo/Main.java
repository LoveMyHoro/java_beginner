package com.horo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.horo.mapper")//指定mapper文件夹的地址
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
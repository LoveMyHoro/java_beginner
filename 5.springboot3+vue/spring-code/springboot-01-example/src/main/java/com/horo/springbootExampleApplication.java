package com.horo;

import cn.itcast.pojo.Country;
import com.horo.config.CommonImportSelector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.horo.mapper")
@Import(CommonImportSelector.class)//这个注解用于导入外部bean
public class springbootExampleApplication
{
    public static void main( String[] args )
    {
        ApplicationContext context=SpringApplication.run(springbootExampleApplication.class, args);
        Country bean = context.getBean(Country.class);
        System.out.println(bean);
    }
}

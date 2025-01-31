package com.horo;

import cn.itcast.pojo.Country;
import cn.itcast.pojo.Province;
import com.horo.config.BeanImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//通过@Import
@Import(BeanImportSelector.class)
public class BeanManagementApplication
{
    public static void main( String[] args )
    {
        ApplicationContext context=SpringApplication.run(BeanManagementApplication.class,args);
        System.out.println(context.getBean(Country.class));
        //这里的name是返回外部类的方法名
        System.out.println(context.getBean("province"));
    }

}

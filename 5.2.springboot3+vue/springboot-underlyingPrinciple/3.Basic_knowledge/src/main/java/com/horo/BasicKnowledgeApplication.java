package com.horo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class BasicKnowledgeApplication
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = SpringApplication.run(BasicKnowledgeApplication.class, args);
        //Base_1
        String applicationName = context.getEnvironment().getProperty("applicationName");
        System.out.println(applicationName);
        //Base_3
        System.out.println(context.getClass());
        BasicKnowledgeApplication bean = context.getBean(BasicKnowledgeApplication.class);
        System.out.println(bean);
        //Base_4
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        BeanDefinition teacherBdf = beanFactory.getBeanDefinition("teacher");
        BeanDefinition userBdf = beanFactory.getBeanDefinition("user");
        System.out.println(teacherBdf.getClass());
        System.out.println(userBdf.getClass());
        //Base_5
        System.out.println(context.getBean("future").getClass());
    }
}

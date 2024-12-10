package com.horo.test;

import com.horo.part_03_ioc容器的创建和使用.HappyComponent;
import com.horo.part_04_组件作用域和周期方法配置.JavaBean2;
import com.horo.part_05_FactoryBean特性和使用.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ioc容器创建和读取组件的测试类
 */
public class SpringIoCTest {
    /**
     * 讲解如何创建ioc容器并且读取配置文件
     */
    public void creatIo(){
        //方式1:实例化并且指定配置文件
        //参数：String...locations 传入一个或者多个配置文件
        ApplicationContext context1 = new ClassPathXmlApplicationContext("spring-03.xml");

        //方式2:先实例化，再指定配置文件，最后刷新容器触发Bean实例化动作 [springmvc源码和contextLoadListener源码方式]
        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext();
        //设置配置配置文件,方法参数为可变参数,可以设置一个或者多个配置
        context2.setConfigLocations("spring-03.xml");
        //后配置的文件,需要调用refresh方法,触发刷新配置
        context2.refresh();
    }
    /**
     * 讲解如何在Ioc容器中获取组件Bean
     */
    @Test
    public void getBeanFromIo(){
        //步骤1.创建ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-03.xml");
        //步骤2.根据类型获取组件对象
        //TODO:根据bean的类型获取，同一个类型，在ioc容器中只能有一个bean
        //TODO:如果ioc容器存在多个同类型的bean(就是class相同),会出现“NoUniqueBeanDefinitionException”错误
        //TODO:ioc的配置一定实现类，但是可以根据接口获取值，这是多态的知识
        HappyComponent happyComponent = context.getBean(HappyComponent.class);
        happyComponent.doWork();
    }

    /**
     * ioc的创建和销毁实验
     */
    @Test
    public void test04(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-04.xml");
        context.close();
    }
    @Test void test04_2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-04.xml");
        JavaBean2 javaBean1 = context.getBean(JavaBean2.class);
        JavaBean2 javaBean2 = context.getBean(JavaBean2.class);
        //两个类应该不一样，因为是在多例的情况下
        System.out.println(javaBean1==javaBean2);
    }
    @Test
    public void test05(){
        //1.创建ioc容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-05.xml");
        //2.1:获得组件类
        JavaBean javaBean = context.getBean(JavaBean.class);
        System.out.println(javaBean.getName());
        //2.2:获得BeanFactory
        Object BeanFactory = context.getBean("&javaBean");
        System.out.println(BeanFactory);

    }
}

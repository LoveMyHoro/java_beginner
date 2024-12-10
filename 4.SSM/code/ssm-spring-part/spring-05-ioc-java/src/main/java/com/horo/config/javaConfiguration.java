package com.horo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName javaConfiguration
 * @Author iove
 * @Date 2024/9/29 上午8:23
 * @Version 1.0
 * @Description TODO java的配置类，替代xml配置文件
 * 一.使用方法
 *  1.@Configuration注解代表这个类是注解类
 *  2.@PropertySource:引入外部配置文件
 *  3.@ComponentScan:包扫描注解配置，就是要运行的那个包就注解哪个包
 *  4.@Import：导入其他配置类，相当于整合配置类
 * 二.注意点
 *  1.利用@bean注解可以使用外部配置文件的变量
 *  2.@bean绘会真正的让配置类的方法创建的组件存储到ioc容器
 *  三.补充
 *  问题1：beanName的问题
 *      默认：方法名
 *      指定：name/value属性起名字，覆盖方法名
 *  问题2：周期方法如何置顶
 *      原有注解方案： PostConstruct+PreDestroy注解指定
 *      bean属性指定：initMethod+destroyMethod指定
 *  问题3：作用域
 *      和以前一样@Scope注解，默认是单例
 *  问题4：如何引用其他组件
 *      方案1：如果其他组件也是@bean方法，可以直接调用 | 从ioc容器获取组件
 *      方案2：作为形参列表传入，可以是一个也可以是多个，ioc容器会注入
 *
 *
 *
 **/
@Import(value = javaConfigurationA.class)//导入其他配置类，相当于整合配置类
@Configuration//注解代表这个类是注解类
@PropertySource(value = "classpath:jdbc.properties")//引入外部配置文件
@ComponentScan("com.horo.ioc_01_配置类方式管理Bean")//包扫描注解配置，就是要运行的那个包就注解哪个包
public class javaConfiguration {
    //2.利用@bean注解引入外部配置文件的变量
    @Value("${atguigu.url}")
    private String url;
    @Value("${atguigu.driver}")
    private String driver;
    @Value("${atguigu.username}")
    private String username;
    @Value("${atguigu.password}")
    private String password;
    //1.@Bean标识的方法：方法返回值类型==bean组件的类型或者它的接口和父类。类似与xml文件中的<bean>标签
    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;

    }
}

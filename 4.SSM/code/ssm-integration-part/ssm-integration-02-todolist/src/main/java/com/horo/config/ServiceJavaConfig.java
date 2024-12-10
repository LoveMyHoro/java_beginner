package com.horo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @ClassName ServiceJavaConfig
 * @Author iove
 * @Date 2024/10/21 下午8:38
 * @Version 1.0
 * @Description TODO 这个是service层的配置类
 *
 * 主要的配置有：
 * 1.service类扫描
 * 2.开启aop注解的支持 aspect:@Before,@After,@AfterReturning,@AfterThrowing,@Around,@Aspect,@Order
 * 3.tx声明式事物管理 (1)对应的事物管理器的实现。(2)开启事物注解的支持。(3)Transactional
 *
 **/
@Configuration
@ComponentScan("com.horo")
@EnableAspectJAutoProxy//2.开启aop注解的支持
@EnableTransactionManagement//3.开启事物管理
public class ServiceJavaConfig {
    @Bean//3.tx声明式事物管理
    public TransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}

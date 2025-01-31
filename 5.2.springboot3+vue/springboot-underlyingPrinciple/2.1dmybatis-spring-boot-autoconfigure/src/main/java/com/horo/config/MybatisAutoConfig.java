package com.horo.config;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MybatisAutoConfig
 * @Author iove
 * @Date 2024/11/25 下午8:37
 * @Version 1.0
 * @Description TODO
 **/
@AutoConfiguration//表示当前类是一个自动配置类
public class MybatisAutoConfig {
	//1.创建注入sqlSessionFactoryBean的方法
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		return sessionFactoryBean;
	}
	//2.返回扫描包的注解
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(BeanFactory beanFactory){
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		//扫描的包：启动类所在的包及其子包
		List<String>packages = AutoConfigurationPackages.get(beanFactory);
		String p=packages.get(0);
		mapperScannerConfigurer.setBasePackage(p);
		//扫描的注解
		mapperScannerConfigurer.setAnnotationClass(Mapper.class);
		return mapperScannerConfigurer;
	}
}

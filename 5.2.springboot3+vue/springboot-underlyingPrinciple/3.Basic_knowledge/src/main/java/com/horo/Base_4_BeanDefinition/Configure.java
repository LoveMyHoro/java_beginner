package com.horo.Base_4_BeanDefinition;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @ClassName Configure
 * @Author iove
 * @Date 2024/11/26 下午7:46
 * @Version 1.0
 * @Description TODO
 **/
@Service
public class Configure {
	//添加@Bean注解的Bean都会封装到ConfigurationClassBeanDefinition中
	@Bean
	public void teacher(){
		System.out.println("teacher");
	}
}

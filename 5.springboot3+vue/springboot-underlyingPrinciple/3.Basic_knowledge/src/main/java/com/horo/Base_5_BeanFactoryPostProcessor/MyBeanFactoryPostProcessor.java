package com.horo.Base_5_BeanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyBeanFactoryPostProcessor
 * @Author iove
 * @Date 2024/11/26 下午8:09
 * @Version 1.0
 * @Description TODO
 **/
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	//当BeanFactory实例化之后(Bean创建之前)，回调这个函数，注册一些BeanDefinition
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
		genericBeanDefinition.setBeanClass(Future.class);

		//将父类ConfigurableListableBeanFactory的实例强转为强转为DefaultListableBeanFactory类型
		DefaultListableBeanFactory dbf=(DefaultListableBeanFactory)beanFactory;
		dbf.registerBeanDefinition("future",genericBeanDefinition);
	}
}

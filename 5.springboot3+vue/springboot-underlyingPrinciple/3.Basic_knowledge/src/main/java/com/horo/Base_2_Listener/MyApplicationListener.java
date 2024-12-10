package com.horo.Base_2_Listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @ClassName MyListener
 * @Author iove
 * @Date 2024/11/25 下午10:16
 * @Version 1.0
 * @Description TODO ApplicationListener用于监听各种事件并做出反应
 **/
//ApplicationListener用于监听各种事件并做出反应
public class MyApplicationListener implements ApplicationListener {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		//如果容器初始化成功
		if(event instanceof ApplicationReadyEvent){
			System.out.println("MyApplicationListener...容器初始化成功");
		}
		//如果容器初始化失败
		if(event instanceof ApplicationFailedEvent){
			System.out.println("MyApplicationListener...容器初始化失败");
		}
		//然后就是到META-INF中创建spring.factories，再填写类的全路径，让springboot能读取到
	}
}

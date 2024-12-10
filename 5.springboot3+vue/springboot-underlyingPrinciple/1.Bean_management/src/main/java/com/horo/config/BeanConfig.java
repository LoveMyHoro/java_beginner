package com.horo.config;

import cn.itcast.pojo.Country;
import cn.itcast.pojo.Province;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName BeanCOnfig
 * @Author iove
 * @Date 2024/11/20 下午8:53
 * @Version 1.0
 * @Description TODO
 **/
@Configuration
public class BeanConfig {
	//利用@Bean注解引入外部的bean对象
	@Bean
	//这个注解表示只有当配置文件中有对应的属性，才声明这个bean
	//这里prefix指的是配置属性的前缀,name={}表示对应的值
	@ConditionalOnProperty(prefix = "country",name ={"name","system"})
	public Country country(@Value("${Country.name}") String name,@Value("${Country.system}") String system){
		Country country=new Country();
		country.setName(name);
		country.setSystem(system);
		return country;
	}
	//这个注解表示当不存在当前类型的.class时，才注入这个bean
	//@ConditionalOnMissingBean(Country.class)
	@Bean
	public Province province(){
		Province province=new Province();
		return province;
	}
}

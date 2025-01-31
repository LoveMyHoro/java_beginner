package com.horo.config;

import cn.itcast.pojo.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName com.horo.config.CommonConfig
 * @Author iove
 * @Date 2024/10/31 下午3:50
 * @Version 1.0
 * @Description TODO  这个注解类是用来导入外部Bean
 **/
@Configuration
public class CommonConfig {
    /**
     *1.注入外部Bean对象，默认方法名是对象名称
     * @return
     */
    @Bean
    public Country getCountry(@Value("${country.name}")String name, @Value("${country.system}")String system){
        Country country = new Country();
        country.setName(name);
        country.setSystem(system);
        return  country;
    }
}

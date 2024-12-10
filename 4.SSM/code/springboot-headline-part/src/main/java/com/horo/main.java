package com.horo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName main
 * @Author iove
 * @Date 2024/10/28 上午11:13
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootApplication
@MapperScan("com.horo.mapper")
public class main {
    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }
    //将拦截器加入到ioc容器中
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));//分页
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());//乐观锁
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());//防止全局修改和删除
        return interceptor;
    }
}

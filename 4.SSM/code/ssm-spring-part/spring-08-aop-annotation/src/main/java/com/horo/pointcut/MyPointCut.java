package com.horo.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyPointCut
 * @Author iove
 * @Date 2024/10/5 下午5:33
 * @Version 1.0
 * @Description TODO
 **/
@Component
public class MyPointCut {
    @Pointcut("execution(* com.horo.service.impl.*.*(..))")
    public void myPointCut() {

    }
}

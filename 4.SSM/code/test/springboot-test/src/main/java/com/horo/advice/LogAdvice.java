package com.horo.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogAdvice
 * @Author iove
 * @Date 2024/10/25 下午6:18
 * @Version 1.0
 * @Description TODO
 **/
@Component
@Aspect//Aop切面注解
@Order(1)
public class LogAdvice {
    @Before("execution(* com..service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        System.out.println(className+"::"+methodName+"::"+"开始执行力");
    }
}

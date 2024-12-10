package com.horo.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * @ClassName LogAdvice
 * @Author iove
 * @Date 2024/10/5 下午3:51
 * @Version 1.0
 * @Description TODO
 **/
@Component
@Aspect
@Order(1)
public class LogAdvice {
    @Before("com.horo.pointcut.MyPointCut.myPointCut()")
    public void before(JoinPoint joinPoint){
        //从JoinPoint中获得目标类的信息
        //1.获取方法属于类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        //2.获取方法名称
        int modifiers = joinPoint.getSignature().getModifiers();
        String s= Modifier.toString(modifiers);
        String name= joinPoint.getSignature().getName();
        //3.获取参数列表
        Object [] args = joinPoint.getArgs();
        System.out.println("方法开始了");

    }
    @AfterReturning(value = "com.horo.pointcut.MyPointCut.myPointCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println();
    }
    @After("com.horo.pointcut.MyPointCut.myPointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("方法结束了");
    }
    @AfterThrowing(value = "com.horo.pointcut.MyPointCut.myPointCut()",throwing = "t")
    public void afterThrowing(JoinPoint joinPoint,Throwable t){
        System.out.println("方法报错了");
    }
}

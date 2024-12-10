package com.horo.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogAdviceAround
 * @Author iove
 * @Date 2024/10/5 下午5:44
 * @Version 1.0
 * @Description TODO 返回值类型和参数一定不能省略
 **/
@Aspect
@Component
@Order(2)
public class LogAdviceAround {
    @Around("com.horo.pointcut.MyPointCut.myPointCut()")
    public Object logAdvice(ProceedingJoinPoint joinPoint){
        //获得目标方法参数
        Object [] args = joinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("开启事物Around");
            //proceed()自己决定方法执行的位置
            result=joinPoint.proceed();
            System.out.println("结束事物Around");
        } catch (Throwable e) {
            System.out.println("事物回滚Around");
            throw new RuntimeException(e);
        }finally {

        }
        return result;
    }
}

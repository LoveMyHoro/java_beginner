package com.horo.error;

import jakarta.enterprise.inject.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Author iove
 * @Date 2024/10/18 下午3:43
 * @Version 1.0
 * @Description TODO
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    //全局的异常处理
    @ExceptionHandler(Exception.class)
    public Object exception(Exception e) {
        System.out.println("e"+e.getMessage());
        return e.getMessage();
    }
    //空指针异常处理
    @ExceptionHandler(NullPointerException.class)
    public Object NullPointerException(NullPointerException e) {
        System.out.println("e"+e.getMessage());
        return e.getMessage();
    }
}

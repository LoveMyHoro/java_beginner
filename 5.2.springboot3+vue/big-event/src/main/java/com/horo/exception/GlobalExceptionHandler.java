package com.horo.exception;

import com.horo.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Author iove
 * @Date 2024/11/2 上午11:45
 * @Version 1.0
 * @Description TODO 这个是全局异常处理类
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception exception){
        exception.printStackTrace();
        return Result.error(exception.getMessage());
    }

}

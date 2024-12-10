package com.horo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @ClassName MyInterceptor
 * @Author iove
 * @Date 2024/10/25 下午3:29
 * @Version 1.0
 * @Description TODO
 **/

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器启动了");
        return true;
    }
}

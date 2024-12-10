package com.horo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName MyInterceptor
 * @Author iove
 * @Date 2024/10/18 下午4:11
 * @Version 1.0
 * @Description TODO
 **/

public class MyInterceptor implements HandlerInterceptor {
    /**
     *  1.这个是执行handler之前调用的拦截方法
     * @param request 请求的对象
     * @param response 相应的对象
     * @param handler 要调用的方法对象
     * @return true:放行请求，false:拦截请求
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("这个是执行handler之前调用的拦截方法");
        return true;
    }

    /**
     * 2.这个是方法完成后触发的方法，但前提是preHandle返回true放行了方法
     * 无拦机制
     * @param request
     * @param response
     * @param handler
     * @param modelAndView 返回的视图和共享域对象
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("这个是方法完成后触发的拦截方法");
    }

    /**
     * 3.这个是在整个请求完成后执行的方法
     * @param request
     * @param response
     * @param handler
     * @param ex 如果handler报错了，这个就是异常对象
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("这个是在整个请求完成后执行的拦截方法");
    }

}

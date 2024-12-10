package com.horo.interceptor;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.horo.utils.JwtHelper;
import com.horo.utils.Result;
import com.horo.utils.ResultCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ResourceBundle;

/**
 * @ClassName LoginProtectInterceptor
 * @Author iove
 * @Date 2024/10/29 下午10:48
 * @Version 1.0
 * @Description TODO 这个是拦截器的类。要实现HandlerInterceptor，之后还要在配置文件中将拦截器配置到容器中
 **/
@Component
public class LoginProtectInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器启动！！！");
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)||jwtHelper.isExpiration(token)){
            Result result=Result.build(null, ResultCodeEnum.NOTLOGIN);
            //将result转为字符串放入response
            ObjectMapper objectMapper=new ObjectMapper();
            String json=objectMapper.writeValueAsString(result);
            response.getWriter().write(json);
            System.out.println("token有误，已被拦截");
            return false;
        }
        System.out.println("拦截器放行");
        return true;
    }
}

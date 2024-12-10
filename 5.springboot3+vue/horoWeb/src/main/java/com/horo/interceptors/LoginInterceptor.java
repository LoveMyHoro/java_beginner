package com.horo.interceptors;

import com.horo.utils.JwtHelper;
import com.horo.utils.Result;
import com.horo.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @ClassName LoginInterceptor
 * @Author iove
 * @Date 2024/11/14 下午3:07
 * @Version 1.0
 * @Description TODO 这个类是用来检验用户是否登录
 **/
@Component
@CrossOrigin
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //1.检验token是否为空或者过期
        if(jwtHelper.isExpiration(token)||token==null){
            response.setStatus(401);
            System.out.println("token已过期");
            return false;
        }
        //2.将id放入ThreadLocal
        int id=jwtHelper.getUserId(token).intValue();
        ThreadLocalUtil.set(id);
        return true;
    }
}

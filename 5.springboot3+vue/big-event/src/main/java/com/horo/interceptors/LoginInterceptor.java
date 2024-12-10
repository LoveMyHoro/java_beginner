package com.horo.interceptors;

import com.horo.utils.JwtHelper;
import com.horo.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @ClassName LoginInterceptors
 * @Author iove
 * @Date 2024/11/2 下午6:20
 * @Version 1.0
 * @Description TODO 拦截器
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String redisToken = stringRedisTemplate.opsForValue().get(token);
        System.out.println("redisToken:"+redisToken);

        if(jwtHelper.isExpiration(token)||redisToken==null){
            response.setStatus(401);
            return false;
        }
        //将id放入ThreadLocal
        int id=jwtHelper.getUserId(token).intValue();
        ThreadLocalUtil.set(id);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //在结束后清除ThreadLocal中的数据，防止内存泄露
        ThreadLocalUtil.remove();
    }
}

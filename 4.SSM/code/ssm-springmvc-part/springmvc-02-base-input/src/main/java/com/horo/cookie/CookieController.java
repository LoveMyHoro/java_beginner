package com.horo.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.http.HttpResponse;

/**
 * @ClassName CookieController
 * @Author iove
 * @Date 2024/10/16 下午4:33
 * @Version 1.0
 * @Description TODO
 **/
@Controller
@ResponseBody
@RequestMapping("/cookie")
public class CookieController {
    @RequestMapping("/data")
    public String data(@CookieValue(value = "cookieName")String value) {
        System.out.println("value:"+value);
        return value;
    }

    @GetMapping("save")
    public String save(HttpServletResponse response) {
        Cookie cookie = new Cookie("cookieName", "root");
         response.addCookie(cookie);
         return "ok";
    }
}
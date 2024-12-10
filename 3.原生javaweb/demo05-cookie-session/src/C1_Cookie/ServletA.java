package C1_Cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建cookie
        Cookie cookieA = new Cookie("cookieA", "valueA");
        Cookie cookieB = new Cookie("cookieB", "valueB");
        //2.设置cookie时效，单位是秒
        cookieA.setMaxAge(60*5);
        //3.设置Cookie的提交路径
        //只有包含的路径才能接收到这个cookie
        cookieA.setPath("servletB");
        //4.将cookie放入响应对象
        resp.addCookie(cookieA);
        resp.addCookie(cookieB);
    }
}

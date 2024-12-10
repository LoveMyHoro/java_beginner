package C1_Cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求中的cookie
        Cookie []cookies = req.getCookies();
        //2.迭代cookie数组
        if(null!=cookies && cookies.length>0){
            for(Cookie cookie:cookies){
                System.out.println(cookie.getName()+":"+cookie.getValue());
            }
        }
    }
}

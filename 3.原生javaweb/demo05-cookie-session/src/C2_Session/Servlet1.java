package C2_Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收请求中的username参数，
        // 这个可以在浏览器中访问servlet1时，在servlet1地址后添加?username=""赋予
        String username = req.getParameter("username");

        //2.获得session对象
        /*判断请求中有没有一个特殊的cookie JSESSIONID 值 *** ***
            1.有
                根据JSESSIONID找对应的session对象
                    (1)找到了
                        返回之前的session
                    (2)没找到
                        创建一个新的session返回，并且向response对象中存放一个JSESSIONID的cookie
             2.没有
                创建一个新的session返回，并且向response对象中存放一个JSESSIONID的cookie
         */
        HttpSession session = req.getSession();
        //设置session最大生存时间，单位是秒
        session.setMaxInactiveInterval(60*5);

        //获取session的id
        System.out.println(session.getId());
        //判断是不是新的JSESSIONID
        System.out.println(session.isNew());
        //将username放入session
        session.setAttribute("username", username);

        //客户端响应信息
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("成功");

    }
}

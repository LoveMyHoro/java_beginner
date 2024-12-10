import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
//HttpServletRequest相关API
@WebServlet(value = "/s1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取url信息
        //获取主机名
        String serverName = request.getServerName();
        System.out.println("serverName = " + serverName);
        //获取端口号
        int serverPort = request.getServerPort();
        System.out.println("serverPort = " + serverPort);
        //获取协议
        String scheme = request.getScheme();
        System.out.println("scheme = " + scheme);
        //获取上下文路径(※)
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);

        //2.获取请求头信息
        //获得user-Agent信息
        String userAgent = request.getHeader("User-Agent");
        System.out.println("userAgent = " + userAgent);
        //获得referer请求源
        String referer = request.getHeader("Referer");
        System.out.println("referer = " + referer);

        //3.获取请求方式
        String method = request.getMethod();
        System.out.println("method = " + method);

    }
}

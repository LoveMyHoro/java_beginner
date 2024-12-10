import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
//ServletContext获取文件路径和项目部署的上下文路径
@WebServlet("/s4")
public class Servlet4 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获得一个指向项目部署位置下某个文件/目录的磁盘真实路径
        ServletContext servletContext=getServletContext();
        String path=servletContext.getRealPath("upload");
        System.out.println(path);
        //2.获得项目部署的上下文路径 项目的访问路径
        String contextPath=servletContext.getContextPath();
        System.out.println(contextPath);
    }
}

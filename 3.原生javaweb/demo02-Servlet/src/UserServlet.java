import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
    问题1_Servlet开发流程
    1.创建javaWEB项目，同时将tomcat添加为当前项目的依赖
    2.重写Service方法 service(HttpServletRequest req, HttpServletResponse resp)
    3.在Service方法中，定义业务处理代码
    4.在web.xml中配置Servlet对应的请求映射路径
 */
/*
   1.Content-Type响应头的问题
    MINE 类型的响应头  媒体类型，文件类型，响应的数据类型
    MINE类型用于告诉客户端响应的数据是什么类型的数据，客户端根据返回的数据决定用什么方式解析响应体
 */
import java.io.IOException;
import java.security.Provider;

public class UserServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中的参数
        String username = req.getParameter("username");

        //设置Content-Type响应头
        resp.setContentType("text/html");
        if("atguigu".equals(username)){
            //通过响应对象响应信息
            resp.getWriter().write("NO");
        }else{
            resp.getWriter().write("YES");
        }

    }
}

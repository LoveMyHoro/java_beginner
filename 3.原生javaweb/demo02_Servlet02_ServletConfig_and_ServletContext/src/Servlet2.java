import com.sun.jdi.Value;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.foreign.ValueLayout;
import java.util.Enumeration;

/*
利用注解用来配置Servlet的初始参数
 */
@WebServlet(
        urlPatterns = "/s2",
        initParams = {@WebInitParam(name = "key2a",value = "value2a"),@WebInitParam(name = "key2b",value="value2b")}
)
public class Servlet2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        // 根据参数名获取单个参数
        String value = servletConfig.getInitParameter("key2a");
        System.out.println("keya:"+value);
        // 获取所有参数名
        Enumeration<String> parameterNames = servletConfig.getInitParameterNames();
        // 迭代并获取参数名
        //hasMoreElements()判断有没有下一个元素，返回true或者false
        //nextElement() 取出元素，指针右移
        while (parameterNames.hasMoreElements()) {
            String paramaterName = parameterNames.nextElement();
            System.out.println(paramaterName+":"+servletConfig.getInitParameter(paramaterName));
        }
    }
}

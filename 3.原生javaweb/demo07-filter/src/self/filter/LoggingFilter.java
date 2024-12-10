package self.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.LogRecord;
/*
    Filter过滤器实现步骤
    1.实现Filter接口
    2.重写过滤方法
    3.配置过滤器
        两种方式(1)web.xml(2)注解

 */
//注意，要在web.xml中配置过滤器以及过滤器的过滤范围
//doFilter决定是否要放行
public class LoggingFilter implements Filter {
    //SimpleDateFormat 是 Java 中的一个类，用于格式化和解析日期和时间
    //
    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 参数父转子
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 拼接日志文本
        String requestURI = request.getRequestURI();
        String time = dateFormat.format(new Date());
        String beforeLogging = requestURI + "在" + time + "被请求了";
        //打印日志
        System.out.println(beforeLogging);
        //获取系统时间
        long t1=System.currentTimeMillis();
        //放行请求
        chain.doFilter(request,response);
        //再次获取系统时间
        long t2=System.currentTimeMillis();
        //拼接日志文本
        String afterLogging = requestURI+"在"+time+"的请求耗时"+(t2-t1)+"ms";
        //打印日志
        System.out.println(afterLogging);
        //注意，要在web.xml中配置过滤器以及过滤器的过滤范围
    }

}

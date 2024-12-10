package schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.http.HttpRequest;
//这个是抽取出来的方法，作为Schedule和User的父类，用来接收客户端的请求
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断此次请求的需求，增？删？改？查？
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String MethodName = split[split.length - 1];
        //使用反射获取方法名
        //这里结束后会直接调用类中或子类中同名的方法
        Class aClass = this.getClass();
        try {
            //传入方法名和参数的自解码文件
            Method declaredMethod = aClass.getDeclaredMethod(MethodName, HttpServletRequest.class, HttpServletResponse.class);
            //暴力破解方法的访问修饰符的限制
            declaredMethod.setAccessible(true);
            //执行方法
            declaredMethod.invoke(this, req, resp);
        } catch (Exception e) {
            //打印错误日志,但程序不会停止
            e.printStackTrace();
        }

    }
}

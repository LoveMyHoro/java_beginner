import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

//HttpServletResponse相关API
@WebServlet("/s3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置响应行相关API
        resp.setStatus(200);//状态码
        //要返回的信息
        String info="<h1>明日香</h1>";
        //2.设置响应头相关API
        resp.setContentType("text/html");//设置返回的类型
        resp.setContentLength(info.getBytes().length);//设置返回数据的长度
        //3.设置响应体内容API
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(info);




    }
}

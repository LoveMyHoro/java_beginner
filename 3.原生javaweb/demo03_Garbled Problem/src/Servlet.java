import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpClient;
@WebServlet("/s")
public class Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应体，用UTF-8编码
        resp.setCharacterEncoding("UTF-8");
        //设置ContentType响应头，告诉客户端用UTF-8解码
        resp.setContentType("text/html;charset=UTF-8");
        //向客户端响应一些文字
        resp.getWriter().write("明日香");
    }
}

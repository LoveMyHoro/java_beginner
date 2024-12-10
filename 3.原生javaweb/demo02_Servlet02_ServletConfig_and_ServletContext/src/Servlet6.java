import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
//读取ServletContext域的数据
@WebServlet("/s6")
public class Servlet6 extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletContext servletContext=getServletContext();
        String ka=(String) servletContext.getAttribute("明日香");
        System.out.println(ka);

    }
}

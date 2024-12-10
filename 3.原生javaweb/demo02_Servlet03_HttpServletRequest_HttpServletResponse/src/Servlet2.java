import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
//HttpServletRequest相关API
@WebServlet(value = "/s2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //4.获取请求参数（无论是在网址栏拼接，还是在请求体，如下方式都可以获取到）
        //获取单个值
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        String password = request.getParameter("password");
        System.out.println("password = " + password);

        //获取多个值
        String[] soccerTeams = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(soccerTeams));

        //获取所有参数名从而获取参数值
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            //不管单个参数还是多个参数，都当作多个参数
            String []value=request.getParameterValues(parameterName);
            System.out.println(parameterName+"="+Arrays.toString(value));
        }
        //返回所有参数的map集合 key=参数名 value=参数名
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            String name = entry.getKey();
            String [] values = entry.getValue();
            if(values.length>1){
                System.out.println(name+"="+Arrays.toString(values));
            }
            else{
                System.out.println(name+"="+values[0]);
            }
        }

        //获取请求体中非键值对的数据 如json串，文件
        //json串
        BufferedReader reader = request.getReader();
        //文件
        ServletInputStream inputStream = request.getInputStream();
    }
}

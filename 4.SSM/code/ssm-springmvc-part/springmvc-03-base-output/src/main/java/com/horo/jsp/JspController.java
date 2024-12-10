package com.horo.jsp;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName JspController
 * @Author iove
 * @Date 2024/10/16 下午6:58
 * @Version 1.0
 * @Description TODO
 **/
@Controller
@RequestMapping("jsp")
/**1.快速查找视图
 *   (1)方法的返回值是字符串类型
 *   (2)不添加@ResponseBody注解,因为添加了这个注解后就不会访问视图资源了
 */
public class JspController {
    //1.跳转页面
    @GetMapping("index")
    public String index(HttpServletRequest request){
        request.setAttribute("data","hello jsp");
        System.out.println("jsp gogogo");
        return "index";
    }
    //2.转发
    //固定格式forward:+转发的uri
    @GetMapping("forward")
    public String forward(){
        System.out.println("JspController forward");
        return "forward:/jsp/index";
    }
    //3.重定向
    //固定格式redirect:+完整的url
    @GetMapping("redirect/baidu")
    public String redirect(){
        System.out.println("JspController redirect");
        return "redirect:http://www.baidu.com";
    }

}

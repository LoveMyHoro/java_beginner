package schedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schedule.common.Result;
import schedule.common.ResultCodeEnum;
import schedule.pojo.SysUser;
import schedule.service.impl.SysScheduleServiceimpl;
import schedule.service.impl.SysUserServiceimpl;
import schedule.util.MD5Util;
import schedule.util.WEBUtil;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*")
public class SysUserController  extends BaseController {

    static SysUserServiceimpl service = new SysUserServiceimpl();

    public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.接收客户端提交的json参数，并转换为User对象，获取信息
        SysUser register=WEBUtil.readJson(request, SysUser.class);
        //2.调用服务层方法，完成注册方法
        int rows=service.regist(register);
        //3.根据注册的结果做页面的跳转
        Result result=Result.ok(null);
        if(rows<0){
            result=Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WEBUtil.writeJson(response,result);
    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收用户请求参数
        // 获取要登录的用户名密码
        SysUser inputUser = WEBUtil.readJson(request, SysUser.class);
        // 调用服务层方法,根据用户名查询数据库中是否有一个用户
        SysUser loginUser =service.findByUserName(inputUser.getUsername());

        Result result = null;

        if(null == loginUser){
            // 没有根据用户名找到用户,说明用户名有误
            result=Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }else if(! loginUser.getUserPwd().equals(MD5Util.encrypt(inputUser.getUserPwd()))){
            // 用户密码有误,
            result=Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        }else{
            // 登录成功
            //利用map将用户uid和username响应给客户端
            Map data=new HashMap();
            loginUser.setUserPwd("");
            data.put("loginUser",loginUser);
            result=Result.ok(data);
        }

        WEBUtil.writeJson(response,result);
    }

    /**
     * 判断用户名是否以经被注册
     * @param request
     * @param response
     * @throws IOException
     */
    public void checkOnlyUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        SysUser user = service.findByUserName(username);
        response.setContentType("text/html");
        Result result=Result.ok(null);
        if(user!=null){
            result=Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        //利用WEBUtil工具类中的方法向客户端传递json串
        WEBUtil.writeJson(response,result);
    }
}

package schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schedule.common.Result;
import schedule.pojo.SysSchedule;
import schedule.service.SysScheduleService;
import schedule.service.impl.SysScheduleServiceimpl;
import schedule.util.WEBUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/schedule/*")
//   "/schedule/*"中，"/*"表示匹配时schedule后面可以有其他内容，比如 /schedule/add。否则会不匹配
public class SysScheduleController extends BaseController {
/**
 * 1.增加日程的请求    /schedule/add
 * 2.查询日程的请求    /schedule/find
 * 3.修改日程的请求    /schedule/update
 * 4.删除日程的请求    /schedule/remove
 */
private SysScheduleService scheduleService = new SysScheduleServiceimpl();
protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) {
    //1.接收请求中的uid参数
    int uid=Integer.parseInt(req.getParameter("uid"));
    //2.查询用户的所有日程
    List<SysSchedule>itemList=scheduleService.findItemListByUid(uid);
    //3.将用户的所有日程放入对象
    Map data=new HashMap();
    data.put("itemList",itemList);
    Result result=Result.ok(data);
    //4.将result对象转换为JSON对象响应给客户端
    WEBUtil.writeJson(resp,result);
}
    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid=Integer.parseInt(req.getParameter("uid"));
        scheduleService.addDefault(uid);
        WEBUtil.writeJson(resp,Result.ok(null));
    }

    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收请求体中的JSON串，转换成一个SysSchedule对象
        SysSchedule schedule=WEBUtil.readJson(req,SysSchedule.class);
        scheduleService.updateSchedule(schedule);
        WEBUtil.writeJson(resp,Result.ok(null));
    }

    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid=Integer.parseInt(req.getParameter("sid"));
        scheduleService.removeSchedule(sid);
        WEBUtil.writeJson(resp,Result.ok(null));
    }
}

package com.horo.controller;

import com.horo.pojo.Schedule;
import com.horo.service.ScheduleService;
import com.horo.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ScheduleController
 * @Author iove
 * @Date 2024/10/23 上午10:56
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("/schedule")
@Slf4j//日志输出的注解
@CrossOrigin//允许不同源的服务器访问controller方法，不会被浏览器拦截。可以加到类上，也可以加到方法上
public class ScheduleController {
    //要注意，方法的是什么Mapping，就要用什么方式去请求，如DeleteMapping就要用Delete方式去请求。
    @Autowired
    private ScheduleService scheduleService;
    @RequestMapping("/findAll")
    public List<Schedule> getScheduleService() {
        List<Schedule> schedules = scheduleService.querySchedule();
        return schedules;
    }
    @GetMapping("/{pageSize}/{currentPage}")
    public R page(@PathVariable("pageSize") int pageSize,
                      @PathVariable("currentPage") int currentPage) {
        R r=scheduleService.Page(pageSize,currentPage);
        log.info("查询的数据为：{}",r);
        return r;
    }
    @PostMapping("/save")
    public R save(@Validated @RequestBody Schedule schedule, BindingResult result) {
        if(result.hasErrors()) {
            return R.fail("参数异常");
        }
        R r=scheduleService.Save(schedule);
        return r;
    }
    @DeleteMapping("/{id}")
    public R remove(@PathVariable Integer id) {
        R r=scheduleService.Remove(id);
        return r;
    }
    @PutMapping("/update")
    public R update(@Validated @RequestBody Schedule schedule, BindingResult result) {
        if(result.hasErrors()) {
            return R.fail("核心参数为空");
        }
        R r=scheduleService.Update(schedule);
        return r;
    }
}

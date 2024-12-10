package com.horo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.horo.mapper.ScheduleMapper;
import com.horo.pojo.Schedule;
import com.horo.service.ScheduleService;
import com.horo.utils.PageBean;
import com.horo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ScheduleServiceImpl
 * @Author iove
 * @Date 2024/10/23 上午10:55
 * @Version 1.0
 * @Description TODO
 **/
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public List<Schedule> querySchedule() {
        List<Schedule> schedules = scheduleMapper.querySchedule();
        return schedules;
    }

    @Override
    public R Page(int pageSize, int currentPage) {
        PageHelper.startPage(currentPage, pageSize);
        List<Schedule> schedules = scheduleMapper.querySchedule();
        PageInfo<Schedule> pageInfo = new PageInfo<>(schedules);
        PageBean<Schedule> pageBean = new PageBean<>(currentPage,pageSize,pageInfo.getTotal(),pageInfo.getList());
        R ok=R.ok(pageBean);
        return ok;
    }

    @Override
    public R Save(Schedule schedule) {
        int row=scheduleMapper.insert(schedule);
        if(row>0){
            return  R.ok(row);
        }
        return R.fail(null);
    }

    @Override
    public R Remove(Integer id) {
        int row=scheduleMapper.deleteById(id);
        if(row>0){
            return R.ok(row);
        }
        return R.fail(null);
    }

    @Override
    public R Update(Schedule schedule) {
        int row=scheduleMapper.update(schedule);
        if(row>0){
            return R.ok(row);
        }
        return R.fail(null);
    }
}

package com.horo.service;

import com.horo.pojo.Schedule;
import com.horo.utils.R;

import java.util.List;

public interface ScheduleService {
    List<Schedule>querySchedule();


    R Page(int pageSize, int currentPage);

    R Save(Schedule schedule);

    R Remove(Integer id);

    R Update(Schedule schedule);
}

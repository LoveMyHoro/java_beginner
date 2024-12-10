package com.horo.mapper;

import com.horo.pojo.Schedule;

import java.util.List;

public interface ScheduleMapper {
    List<Schedule>querySchedule();

    int insert(Schedule schedule);


    int deleteById(Integer id);

    int update(Schedule schedule);
}

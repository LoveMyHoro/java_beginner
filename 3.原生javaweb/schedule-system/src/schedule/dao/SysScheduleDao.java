package schedule.dao;

import schedule.pojo.SysSchedule;

import javax.swing.*;
import java.util.List;

public interface SysScheduleDao {
    /**
     * 向Schedule表插入数据
     * @param schedule 传入的对象
     * @return 返回插入的结果
     */
    int addSchedule(SysSchedule schedule);

    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefault(int uid);

    Integer updateSchedule(SysSchedule schedule);

    Integer removeSchedule(int sid);
}

package schedule.service.impl;

import schedule.dao.SysScheduleDao;
import schedule.dao.impl.SysScheduleDaoimpl;
import schedule.pojo.SysSchedule;
import schedule.service.SysScheduleService;

import java.util.List;

public class SysScheduleServiceimpl implements SysScheduleService {
    private SysScheduleDao sysScheduleDao=new SysScheduleDaoimpl();
    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        return  sysScheduleDao.findItemListByUid(uid);
    }

    @Override
    public Integer addDefault(int uid) {
        return sysScheduleDao.addDefault(uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule schedule) {
        return sysScheduleDao.updateSchedule(schedule);
    }

    @Override
    public Integer removeSchedule(int sid) {
        return sysScheduleDao.removeSchedule(sid);
    }
}

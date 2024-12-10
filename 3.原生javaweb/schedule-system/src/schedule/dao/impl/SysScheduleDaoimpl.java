package schedule.dao.impl;

import schedule.dao.SysScheduleDao;
import schedule.pojo.SysSchedule;

import java.util.List;

public class SysScheduleDaoimpl extends BaseDao implements SysScheduleDao {
    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql="insert into sys_schedule values(DEFAULT,?,?,?)";
        int result = baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
        return result;
    }

    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        String sql="select sid,uid,title,completed from sys_schedule where uid=?";
        List<SysSchedule> itemList = baseQuery(SysSchedule.class, sql, uid);
        return  itemList;
    }

    @Override
    public Integer addDefault(int uid) {
        String sql ="insert into sys_schedule values(DEFAULT,?,'请输入日程',0)";
        return baseUpdate(sql,uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule schedule) {
        String sql ="update sys_schedule set title = ? ,completed =  ? where sid =?";
        return baseUpdate(sql, schedule.getTitle(), schedule.getCompleted(), schedule.getSid());
    }

    @Override
    public Integer removeSchedule(int sid) {
        String sql="delete from sys_schedule where sid = ?";
        return baseUpdate(sql, sid);
    }
}

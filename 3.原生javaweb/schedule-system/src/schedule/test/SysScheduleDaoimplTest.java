package schedule.test;

import org.junit.Test;
import schedule.dao.SysScheduleDao;
import schedule.dao.impl.SysScheduleDaoimpl;
import schedule.pojo.SysSchedule;

public class SysScheduleDaoimplTest {
    @Test
    public void Test(){
        SysScheduleDao dao = new SysScheduleDaoimpl();
        SysSchedule schedule=new SysSchedule(null,1,"吃饭",0);
        int result = dao.addSchedule(schedule);
        System.out.println(result);
    }
}

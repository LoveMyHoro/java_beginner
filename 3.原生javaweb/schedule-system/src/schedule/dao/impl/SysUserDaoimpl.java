package schedule.dao.impl;

import schedule.dao.SysUserDao;
import schedule.pojo.SysSchedule;
import schedule.pojo.SysUser;

public class SysUserDaoimpl extends BaseDao implements SysUserDao {
    @Override
    public int addUser(SysUser user) {
        String sql="insert into sys_user values(DEFAULT,?,?)";
        int result = baseUpdate(sql, user.getUsername(), user.getUserPwd());
        return result;

    }
}

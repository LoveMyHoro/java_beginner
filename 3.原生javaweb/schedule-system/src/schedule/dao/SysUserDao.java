package schedule.dao;

import schedule.pojo.SysUser;

public interface SysUserDao {
    /**
     * 向用户表中添加数据
     * @param user 输入的数据
     * @return 返回添加结果
     */
    int addUser(SysUser user);
}

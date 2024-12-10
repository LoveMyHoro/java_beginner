package schedule.service.impl;

import schedule.dao.SysUserDao;
import schedule.dao.impl.SysUserDaoimpl;
import schedule.pojo.SysUser;
import schedule.service.SysUserService;
import schedule.util.MD5Util;

import java.util.List;

public class SysUserServiceimpl implements SysUserService {
    /**
     * 引入DAO工具包和MD5Util工具包
     */
    static SysUserDaoimpl sysUserDao = new SysUserDaoimpl();
    static MD5Util md5Util = new MD5Util();

    @Override
    public int regist(SysUser user) {
        String sql="insert into sys_user values(DEFAULT,?,?)";
        String s = user.getUsername() + user.getUserPwd();
        System.out.println("用户"+s);
        //对密码进行加密
        user.setUserPwd(md5Util.encrypt(user.getUserPwd()));
        int result = sysUserDao.addUser(user);
        return result;
    }

    @Override
    public SysUser findByUserName(String username) {
        String sql="select uid,username,user_pwd as userPwd from sys_user where username=?";
        List<SysUser> sysUserList = sysUserDao.baseQuery(SysUser.class, sql, username);
        //返回前进行判断
        return sysUserList!=null&&sysUserList.size()>0?sysUserList.get(0):null;
    }
}

package schedule.service;

import schedule.pojo.SysUser;

public interface SysUserService {
    /**
     * 执行客户端的注册请求
     * @param user 传入的注册对象
     * @return  返回受影响的行数
     */
    int regist(SysUser user);

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    SysUser findByUserName(String username);
}

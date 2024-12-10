package schedule.test;

import org.junit.Test;
import schedule.dao.SysUserDao;
import schedule.dao.impl.SysUserDaoimpl;
import schedule.pojo.SysUser;

public class SysUserDaoTest {
    @Test
    public void Test(){
        SysUserDaoimpl sysUserDaoimpl=new SysUserDaoimpl();
        SysUser sysUser=new SysUser(null,"明日香","111111");
        int result = sysUserDaoimpl.addUser(sysUser);
        System.out.println(result);

    }
}

package schedule.test;


import org.junit.BeforeClass;
import org.junit.Test;
import schedule.dao.impl.BaseDao;
import schedule.pojo.SysUser;

import java.util.ArrayList;
import java.util.List;

public class BaseDaoTest {
    private static BaseDao dao;
    @BeforeClass
    public static void initBaseDao(){
        dao = new BaseDao();
    }
    @Test
    public void GetSingle(){
        String sql="select count(1) from sys_user";
        long count=dao.baseQueryObject(long.class,sql);
        System.out.println(count);
    }
    @Test
    public void GetList(){
        String sql="select  uid,username,user_pwd as userPwd from sys_user";
        List<SysUser>sysUserList=dao.baseQuery(SysUser.class,sql);
        sysUserList.forEach(System.out::println);
    }
}

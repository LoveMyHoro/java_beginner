package atguigu_jdbc.jdbc_3_高级篇.j_4_事物;

import atguigu_jdbc.jdbc_3_高级篇.j_2_工具类封装V2.JDBCUtilV2;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class test {
    @Test
    public void test() throws SQLException {
        BankDao bankDao=new BankDaoImpl();

        Connection connection=null;

        try {
            //1.获取连接，将连接的事务提交改为手动提交
            connection= JDBCUtilV2.getConnection();
            connection.setAutoCommit(false);
            //2.操作减钱
            bankDao.subMoney(1,100);

            //故意设置的错误
            //int i=10/0;

            //3.操作加钱
            bankDao.addMoney(2,100);

            //4.前置的多次dao操作，没有异常，提交事务！
            connection.commit();

        } catch (Exception e) {
            connection.rollback();
            throw new RuntimeException(e);
        } finally {
            JDBCUtilV2.release();
        }
    }
}

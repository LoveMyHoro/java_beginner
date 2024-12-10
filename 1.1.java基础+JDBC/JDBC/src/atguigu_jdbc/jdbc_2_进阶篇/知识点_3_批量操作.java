package atguigu_jdbc.jdbc_2_进阶篇;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class 知识点_3_批量操作 {
    @Test
    public void testBatch() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql:///atguigu?rewriteBatchedStatements=true","root","123456");
        //3.编写SQL语句
        /*
            注意：1、必须在连接数据库的URL后面追加?rewriteBatchedStatements=true，允许批量操作
                2、新增SQL必须用values。且语句最后不要追加;结束
                3、调用addBatch()方法，将SQL语句进行批量添加操作
                4、统一执行批量操作，调用executeBatch()
         */
        String sql = "insert into t_emp (emp_name,emp_salary,emp_age) values (?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        long start=System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            preparedStatement.setString(1,"明日香"+i);
            preparedStatement.setDouble(2,1001+i);
            preparedStatement.setInt(3,12);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        long end=System.currentTimeMillis();
        System.out.println("消耗时间："+(end-start));

        preparedStatement.close();
        connection.close();
    }
}

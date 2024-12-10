package atguigu_jdbc.jdbc_3_高级篇.j_2_工具类封装V2;

import java.sql.Connection;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        Connection connection1 = JDBCUtilV2.getConnection();
        Connection connection2 = JDBCUtilV2.getConnection();
        Connection connection3 = JDBCUtilV2.getConnection();
        //三个是相同的连接
        System.out.println(connection1);
        System.out.println(connection2);
        System.out.println(connection3);
    }
}

package atguigu_jdbc.jdbc_3_高级篇.j_1_工具类封装V1;

import java.sql.Connection;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtilV1.getConnection();
        System.out.println(connection);
        JDBCUtilV1.release(connection);

    }
}

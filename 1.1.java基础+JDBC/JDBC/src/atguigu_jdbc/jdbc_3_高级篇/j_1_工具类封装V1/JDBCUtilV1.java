package atguigu_jdbc.jdbc_3_高级篇.j_1_工具类封装V1;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtilV1 {
    /*
*	JDBC工具类（V1.0）：
*		1、维护一个连接池对象。
*		2、对外提供在连接池中获取连接的方法
*		3、对外提供回收连接的方法
*	注意：工具类仅对外提供共性的功能代码，所以方法均为静态方法！
     */
    private static DataSource dataSource;

    static {
        try {
            Properties properties=new Properties();
            InputStream inputStream= JDBCUtilV1.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(inputStream);

            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void release(Connection connection) throws SQLException {
        connection.close();
    }
}

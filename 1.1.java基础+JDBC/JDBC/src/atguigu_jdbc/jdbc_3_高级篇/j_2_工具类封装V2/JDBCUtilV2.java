package atguigu_jdbc.jdbc_3_高级篇.j_2_工具类封装V2;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtilV2 {
/**
 *  JDBC工具类（V2.0）：
 *      1、维护一个连接池对象、维护了一个线程绑定变量的ThreadLocal对象
 *      2、对外提供在ThreadLocal中获取连接的方法
 *      3、对外提供回收连接的方法，回收过程中，将要回收的连接从ThreadLocal中移除！
 *  注意：工具类仅对外提供共性的功能代码，所以方法均为静态方法！
 *  注意：使用ThreadLocal就是为了一个线程在多次数据库操作过程中，使用的是同一个连接！
 */
    private static DataSource dataSource;
    private static java.lang.ThreadLocal<Connection> threadLocal=new java.lang.ThreadLocal<>();

    //传入配置文件并进行相应配置
    static {
        try {
            Properties properties=new Properties();
            InputStream inputStream= JDBCUtilV2.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(inputStream);

            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null) {
            connection=dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;

    }

    public static void release() throws SQLException {
        Connection connection=threadLocal.get();
        if(connection!=null){
            //从threadLocal中移除当前已经存储的Connection对象
            threadLocal.remove();
            //如果开启了事务的手动提交，操作完毕后，归还给连接池之前，要将事务的自动提交改为true
            connection.setAutoCommit(true);
            //将Connection对象归还给连接池
            connection.close();
        }
    }
}

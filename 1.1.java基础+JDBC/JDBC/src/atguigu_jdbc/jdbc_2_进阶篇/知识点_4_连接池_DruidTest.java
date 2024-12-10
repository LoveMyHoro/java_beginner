package atguigu_jdbc.jdbc_2_进阶篇;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class 知识点_4_连接池_DruidTest {
    @Test
    public void testHardCodeDruid() throws SQLException {
        /*
            硬编码：将连接池的配置信息和Java代码耦合在一起。
            1、创建DruidDataSource连接池对象。
            2、设置连接池的配置信息(包含必须设置的和非必须设置的)
            3、通过连接池获取连接对象
            4、回收连接【不是释放连接，而是将连接归还给连接池，给其他线程进行复用】
         */

        //1.创建DruidDataSource连接池对象。
        DruidDataSource druidDataSource=new DruidDataSource();

        //2、设置连接池的配置信息(包含必须设置的和非必须设置的)
        //2.1 必须设置的配置
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql:///atguigu");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");

        //2.2 非必须设置的配置
        //默认连接池内连接的数量
        druidDataSource.setInitialSize(10);
        //最大的数量
        druidDataSource.setMaxActive(20);

        //3.通过连接池获取连接对象
        Connection connection=druidDataSource.getConnection();

        //4.基于connection对数据库进行操作
        PreparedStatement preparedStatement=connection.prepareStatement("select * from t_emp");

        ResultSet resultSet=preparedStatement.executeQuery();

        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            String empSalary = resultSet.getString("emp_salary");
            int empAge = resultSet.getInt("emp_age");
            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }
        resultSet.close();
        preparedStatement.close();

        System.out.println(connection);
        //5.回收连接
        connection.close();
    }



    /*
        软编码实现
     */
    @Test
    public void testSoftCodeDruid() throws Exception {
        //1.创建Properties集合，用于存储外部配置文件的key和value值。
        Properties properties=new Properties();

        //2.读取外部配置文件，获取输入流，加载到Properties集合里。
        //getClassLoader(): 这个方法返回加载 DruidTest 类的类加载器。类加载器的主要任务是加载类和资源。
        //getResourceAsStream("db.properties"): 这是 ClassLoader 的一个方法，用于根据给定的资源名称查找并返回一个输入流。
        // 资源名称通常是相对于类路径（classpath）定位的
        InputStream inputStream = 知识点_4_连接池_DruidTest.class.getClassLoader().getResourceAsStream("db.properties");
        properties.load(inputStream);

        //3.基于Properties集合构建DruidDataSource连接池(通过Druid资源工厂)
        //Druid知道Properties里面存储的是配置信息
        DataSource dataSource= DruidDataSourceFactory.createDataSource(properties);

        //4.通过连接池获取连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //5.开发CRUD

        //6.回收连接
        connection.close();

    }
}

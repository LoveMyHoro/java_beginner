package atguigu_jdbc;

import javax.smartcardio.CommandAPDU;
import java.sql.*;

public class JdbcQuick {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        //从JDK6开始，不再需要显式地调用 `Class.forName()` 来加载 JDBC 驱动程序，
        // 只要在类路径中集成了对应的jar文件，会自动在初始化时注册驱动程序。
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接的对象
        //格式为：jdbc:mysql://IP地址:端口号/数据库名称?参数键值对1&参数键值对2
        String url="jdbc:mysql://localhost:3306/atguigu";
        String username="root";
        String password="123456";

        Connection connection= DriverManager.getConnection(url,username,password);

        //3.获取执行url语句的对象
        Statement statement=connection.createStatement();
        //4.编写sql语句，并执行，接受返回的结果集
        String sql="select * from t_emp";
        ResultSet resultSet=statement.executeQuery(sql);

        //5.处理结果，遍历ResultSet结果集
        while(resultSet.next()){
            int id=resultSet.getInt("emp_id");
            String name=resultSet.getString("emp_name");
            double salary=resultSet.getDouble("emp_salary");
            int age=resultSet.getInt("emp_age");
            System.out.println(id+"\t"+name+"\t"+age+"\t"+salary);
        }

        //6.资源的释放
        resultSet.close();;
        statement.close();
        connection.close();


    }
}

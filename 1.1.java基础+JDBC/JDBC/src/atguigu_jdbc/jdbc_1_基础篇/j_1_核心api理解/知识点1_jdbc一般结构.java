package atguigu_jdbc.jdbc_1_基础篇.j_1_核心api理解;

import java.sql.*;

public class 知识点1_jdbc一般结构 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        //- 从JDK6开始，不再需要显式地调用 `Class.forName()` 来加载 JDBC 驱动程序，
        // 只要在类路径中集成了对应的jar文件，会自动在初始化时注册驱动程序。
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接对象
        //一般格式：jdbc:mysql://IP地址:端口号/数据库名称?参数键值对1&参数键值对2
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "123456");

        //3.创建执行查询语句的Statement对象
        PreparedStatement preparedStatement = connection.prepareStatement("select emp_id,emp_name,emp_salary,emp_age from t_emp");

        //4.执行SQL语句，获取结果
        ResultSet resultSet = preparedStatement.executeQuery();

        //5.处理结果
        //可以通过getXxx的方法获取单列的数据，该方法为重载方法，支持索引和列名进行获取。
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            String empSalary = resultSet.getString("emp_salary");
            int empAge = resultSet.getInt("emp_age");
            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }

        //6.释放资源(先开后关原则)
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}

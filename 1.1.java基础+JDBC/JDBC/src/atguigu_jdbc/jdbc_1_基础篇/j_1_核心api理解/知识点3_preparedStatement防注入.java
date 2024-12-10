package atguigu_jdbc.jdbc_1_基础篇.j_1_核心api理解;

import java.sql.*;
import java.util.Scanner;

public class 知识点3_preparedStatement防注入 {
    public static void main(String[] args) throws SQLException {
        //2.获取连接对象
        //一般格式：jdbc:mysql://IP地址:端口号/数据库名称?参数键值对1&参数键值对2
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "123456");

        //3.创建Statement对象
        PreparedStatement preparedStatement = connection.prepareStatement("select emp_id,emp_name,emp_salary,emp_age from t_emp where emp_name=?");
        System.out.println("请输入要查询的姓名");
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        preparedStatement.setString(1,name);

        //4.执行SQL语句，获取结果
        ResultSet resultSet = preparedStatement.executeQuery();

        //5.处理结果
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

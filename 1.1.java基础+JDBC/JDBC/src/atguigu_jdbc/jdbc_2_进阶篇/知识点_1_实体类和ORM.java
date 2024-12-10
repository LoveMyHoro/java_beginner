package atguigu_jdbc.jdbc_2_进阶篇;

import atguigu_jdbc.jdbc_2_进阶篇.pojo.Employee;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

public class 知识点_1_实体类和ORM {
    /*
    #### 7.1 实体类和ORM
    1. 在使用JDBC操作数据库时，我们会发现数据都是零散的，明明在数据库中是一行完整的数据，到了Java中变成了一个一个的变量，不利于维护和管理。
      而我们Java是面向对象的，一个表对应的是一个类，一行数据就对应的是Java中的一个对象，一个列对应的是对象的属性，
      所以我们要把数据存储在一个载体里，这个载体就是实体类！

    2.ORM（Object Relational Mapping）思想，**对象到关系数据库的映射**，作用是在编程中，把面向对象的概念跟数据库中表的概念对应起来，
    以面向对象的角度操作数据库中的数据，即一张表对应一个类，一行数据对应一个对象，一个列对应一个属性！

    3.当下JDBC中这种过程我们称其为手动ORM。后续我们也会学习ORM框架，比如MyBatis、JPA等。
     */

    //1.将数据库信息封装成对象，并保存在集合中
    @Test
    public void testORM() throws SQLException {
        //1.建立连接
        Connection connection= DriverManager.getConnection("jdbc:mysql:///atguigu","root","123456");

        //2.预编译
        PreparedStatement preparedStatement=connection.prepareStatement("select * from t_emp");

        ResultSet resultSet=preparedStatement.executeQuery();

        Employee employee=null;
        ArrayList<Employee> employeeArrayList=new ArrayList<>();

        //4.处理结果
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");
            employee=new Employee(empId,empName,empSalary,empAge);
            employeeArrayList.add(employee);
        }
        System.out.println(employeeArrayList);
        //5。释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }



}

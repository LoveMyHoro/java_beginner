package atguigu_jdbc.jdbc_2_进阶篇;

import atguigu_jdbc.jdbc_2_进阶篇.pojo.Employee;
import org.junit.Test;

import java.sql.*;

public class 知识点_2_主键回显 {
/*
#### 主键回显

    1.在数据中，执行新增操作时，主键列为自动增长，可以在表中直观的看到，
    但是在Java程序中，我们执行完新增后，只能得到受影响行数，无法得知当前新增数据的主键值。
    在Java程序中获取数据库中插入新数据后的主键值，并赋值给Java对象，此操作为主键回显。
 */
    @Test
    public void testReturnPk() throws SQLException {
        //1.建立连接
        Connection connection= DriverManager.getConnection("jdbc:mysql:///atguigu","root","123456");

        //2.预编译
        //Statement.RETURN_GENERATED_KEYS表示添加成功后可以获取主键
        String sql="insert into t_emp(emp_name, emp_salary, emp_age) values (?,?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        Employee employee=new Employee(null,"明日香",777,28);
        preparedStatement.setString(1,employee.getEmpName());
        preparedStatement.setDouble(2,employee.getEmpSalary());
        preparedStatement.setDouble(3,employee.getEmpAge());
        int result = preparedStatement.executeUpdate();

        ResultSet resultSet=null;
        if(result>0){
            System.out.println("添加成功");
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                int empId = resultSet.getInt(1);
                employee.setEmpId(empId);
         }
        }else{
            System.out.println("添加失败");
        }
        System.out.println(employee.toString());
        if(resultSet!=null){
            resultSet.close();
        }
        preparedStatement.close();
        connection.close();
    }
}

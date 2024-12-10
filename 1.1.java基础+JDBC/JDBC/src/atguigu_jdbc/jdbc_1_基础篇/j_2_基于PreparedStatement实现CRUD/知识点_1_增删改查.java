package atguigu_jdbc.jdbc_1_基础篇.j_2_基于PreparedStatement实现CRUD;

import org.junit.Test;

import java.sql.*;

public class 知识点_1_增删改查 {
    //1.查询单行单列
    @Test
    public void testQuerySingleRowAndCOl() throws SQLException {
        //1.创建连接
        Connection connection= DriverManager.getConnection("jdbc:mysql:///atguigu","root","123456");

        //2.获取PreparedStatement对象，预编译sql语句
        PreparedStatement preparedStatement=connection.prepareStatement("select count(*) as count from t_emp");

        //3执行sql语句
        ResultSet resultSet=preparedStatement.executeQuery();

        //4.获取结果
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1));
        }
        //5.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();


    }

    //2.查询单行多列
    @Test
    public void testQuerySingleRow() throws SQLException {
        //1.建立连接
        Connection connection= DriverManager.getConnection("jdbc:mysql:///atguigu","root","123456");

        //2.预编译
        PreparedStatement preparedStatement=connection.prepareStatement("select * from t_emp where emp_id=?");

        //3.为占位符赋值
        preparedStatement.setInt(1,1);
        ResultSet resultSet=preparedStatement.executeQuery();

        //4.处理结果
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            String empSalary = resultSet.getString("emp_salary");
            int empAge = resultSet.getInt("emp_age");
            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }
        //5。释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    //3.查询多行多列
        @Test
    public void testQueryMoreRow() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql:///atguigu","root","123456");

        PreparedStatement preparedStatement=connection.prepareStatement("select * from t_emp where emp_age>=?");

        preparedStatement.setInt(1,25);

        ResultSet resultSet=preparedStatement.executeQuery();

        //4.处理结果
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            String empSalary = resultSet.getString("emp_salary");
            int empAge = resultSet.getInt("emp_age");
            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }
        //5。释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    //4.插入数据
    @Test
    public void testInsert() throws SQLException {
        Connection connection=DriverManager.getConnection("jdbc:mysql:///atguigu","root","123456");

        PreparedStatement preparedStatement=connection.prepareStatement("insert into t_emp(emp_name,emp_salary,emp_age) values (?,?,?)");

        preparedStatement.setString(1,"明日香");
        preparedStatement.setDouble(2,12333);
        preparedStatement.setInt(3,17);

        int result=preparedStatement.executeUpdate();
        if(result>0){
            System.out.println("添加成功！");
        }
        else{
            System.out.println("添加失败！");
        }
        preparedStatement.close();
        connection.close();


    }

    //5.修改数据
    @Test
    public void testUpdate() throws SQLException {
        Connection connection=DriverManager.getConnection("jdbc:mysql:///atguigu","root","123456");

        PreparedStatement preparedStatement=connection.prepareStatement("update t_emp set emp_salary = ? where emp_id=?;");

        preparedStatement.setDouble(1,666);
        preparedStatement.setInt(2,1);

        int result=preparedStatement.executeUpdate();
        if(result>0){
            System.out.println("修改成功！");
        }
        else{
            System.out.println("修改失败！");
        }
        preparedStatement.close();
        connection.close();
    }

    //6.删除数据
    @Test
    public void testDelete() throws SQLException {
                Connection connection=DriverManager.getConnection("jdbc:mysql:///atguigu","root","123456");

        PreparedStatement preparedStatement=connection.prepareStatement("delete from t_emp where emp_id=?;");

        preparedStatement.setDouble(1,6);

        int result=preparedStatement.executeUpdate();
        if(result>0){
            System.out.println("删除成功！");
        }
        else{
            System.out.println("删除失败！");
        }
        preparedStatement.close();
        connection.close();
    }
}




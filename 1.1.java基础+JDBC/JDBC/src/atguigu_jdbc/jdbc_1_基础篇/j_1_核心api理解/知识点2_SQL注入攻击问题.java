package atguigu_jdbc.jdbc_1_基础篇.j_1_核心api理解;

import java.sql.*;

public class 知识点2_SQL注入攻击问题 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.当使用 `Statement` 执行动态构建的 SQL 查询时，往往需要将查询条件与 SQL 语句拼接在一起，
        // 此时直接将参数和SQL语句一并生成，可能会导致SQL的查询条件始终为true，得到全部结果。


        //2.获取连接对象
        //一般格式：jdbc:mysql://IP地址:端口号/数据库名称?参数键值对1&参数键值对2
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "123456");

        //3.获取执行SQL语句的对象
        Statement statement=connection.createStatement();

        //4.编写SQL语句，并执行，接受返回的执行的结果
        //由于abc' or '1'='1'结果始终为true，查询时会返回所有值。所以会导致注入攻击问题
        String checkName="abc' or '1'='1";
        String sql="select emp_id,emp_name,emp_salary,emp_age from t_emp where emp_name='abc' or '"+checkName+"'";
        ResultSet resultSet=statement.executeQuery(sql);


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
        statement.close();
        connection.close();
    }
}

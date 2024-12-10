package atguigu_jdbc.jdbc_3_高级篇.j_3_Dao;

import atguigu_jdbc.jdbc_3_高级篇.j_3_Dao.imp.Employee;
import atguigu_jdbc.jdbc_3_高级篇.j_3_Dao.imp.EmployeeDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Queue;

//数据库的实现类
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
    @Override
    public List<Employee> selectAll() throws Exception {
        String sql="select emp_id  empId,emp_name empName,emp_salary empSalary,emp_age empAge from t_emp";
        return  executeQuery(Employee.class,sql,null);
    }

    @Override
    public Employee selectByEmpId(Integer empId) throws Exception {
        String sql="select emp_id  empId,emp_name empName,emp_salary empSalary,emp_age empAge from t_emp where emp_id=?";
        return  executeQueryBean(Employee.class,sql,empId);
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        String sql="insert into t_emp(emp_name, emp_salary, emp_age) values(?,?,?);";
        return executeUpdate(sql,employee.getEmpName(),employee.getEmpSalary(),employee.getEmpAge());

    }

    @Override
    public int update(Employee employee) throws SQLException {
        //这里以修改员工工资为例
        String sql="update t_emp set emp_salary=? where emp_id=?;";
        return executeUpdate(sql,employee.getEmpSalary(),employee.getEmpId());
    }

    @Override
    public int delete(Integer empId) throws SQLException {
        String sql="delete from t_emp where emp_id=?";
        return executeUpdate(sql,empId);
    }
}

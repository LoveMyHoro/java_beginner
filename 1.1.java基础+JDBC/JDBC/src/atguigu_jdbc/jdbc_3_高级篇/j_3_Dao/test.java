package atguigu_jdbc.jdbc_3_高级篇.j_3_Dao;

import atguigu_jdbc.jdbc_3_高级篇.j_3_Dao.imp.Employee;
import atguigu_jdbc.jdbc_3_高级篇.j_3_Dao.imp.EmployeeDao;

import javax.lang.model.SourceVersion;
import java.util.List;

public class test {
    public static void main(String[] args) throws Exception {
        //1.查询所有对象
        //创建EmployeeDao实现类对象
        EmployeeDao employeeDao=new EmployeeDaoImpl();

        //调用方法
        List<Employee> employees = employeeDao.selectAll();

        //处理结果
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
        //2.查询单个对象
        Employee employee = employeeDao.selectByEmpId(3);
        System.out.println(employee);

        //3.添加员工
        Employee employee1=new Employee(null,"明日香",300,17);
        int insert = employeeDao.insert(employee1);
        System.out.println("insert = " + insert);

        //4.修改员工工资
        Employee employee2=new Employee(10024,"明日香",1000,28);
        int update = employeeDao.update(employee2);
        System.out.println("update = " + update);

        //5.删除员工信息
        int delete = employeeDao.delete(10024);
        System.out.println("delete = " + delete);


    }
}

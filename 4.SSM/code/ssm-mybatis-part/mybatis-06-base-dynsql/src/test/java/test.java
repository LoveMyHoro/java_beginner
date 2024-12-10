import com.horo.mapper.EmployeeMapper;
import com.horo.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName test
 * @Author iove
 * @Date 2024/10/11 下午10:33
 * @Version 1.0
 * @Description TODO
 **/

public class test {
    private SqlSession session;
     //junit5会在每一个@Test方法前执行@BeforeEach方法
    @BeforeEach
    public void init() throws IOException {
        session= new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
    }
    @Test
    public void testQuery() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        employeeMapper.query("222",222.0);
        System.out.println("查询结果为="+employeeMapper.query(null,100.0));

    }
    @Test
    public void testUpdate() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpId(2);
        employee.setEmpName("aaa");
        employee.setEmpSalary(111.34);
        employeeMapper.update(employee);
    }
    //批量查询
    @Test
    public void testForEach() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Employee> employeeList=employeeMapper.queryBatch(list);
        System.out.println(employeeList);
    }
    // junit会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void end() {
        session.commit();
        session.commit();
    }
}

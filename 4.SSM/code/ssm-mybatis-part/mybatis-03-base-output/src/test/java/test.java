import com.horo.mapper.EmployeeMapper;
import com.horo.mapper.TeacherMapper;
import com.horo.pojo.Employee;
import com.horo.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName test
 * @Author iove
 * @Date 2024/10/8 下午9:29
 * @Version 1.0
 * @Description TODO
 **/

public class test {
    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);


        System.out.println("删除结果="+employeeMapper.deleteById(1));
        System.out.println("查询结果="+employeeMapper.queryNameById(2));
        System.out.println("验证驼峰自动映射="+employeeMapper.queryEmployeeById(2));
        System.out.println("返回map集合="+employeeMapper.selectEmpNameAndMaxSalary());
        System.out.println("返回list集合="+employeeMapper.queryAll());
        Employee employee=new Employee("111",111.1);
        System.out.println("插入前="+employee.getEmpId());
        System.out.println("插入数据结果="+employeeMapper.insert(employee));
        System.out.println("插入后="+employee.getEmpId());

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher=new Teacher("mrx");
        System.out.println("插入前的id="+teacher.getId());
        System.out.println("插入教师结果="+teacherMapper.insertTeacher(teacher));
        System.out.println("插入后的id="+teacher.getId());
        sqlSession.commit();
        sqlSession.close();

    }
}

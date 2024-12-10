import com.horo.mapper.EmployeeMapper;
import com.horo.pojo.Employee;
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
 * @Date 2024/10/8 下午4:12
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
         //查询数据
         System.out.println("查询结果="+employeeMapper.queryById(1));
         //删除数据
         System.out.println("删除受影响行数="+employeeMapper.deleteById(4));
         //插入数据
         Employee employee=new Employee("明日香",111.1);
         System.out.println("插入受影响行数="+employeeMapper.insertEmp(employee));
         //多条件查询数据
        System.out.println("多条件查询结果="+employeeMapper.queryByAll(2,"111"));
         sqlSession.commit();
         sqlSession.close();
    }
}

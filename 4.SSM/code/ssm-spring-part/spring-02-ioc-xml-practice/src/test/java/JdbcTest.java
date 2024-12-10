import com.horo.Student;
import com.horo.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTest {
    /**
     * 测试容器中的JdbcTemplate
     */
    @Test
    public void testJdbcTemplate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-01.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        //1.修改数据
        String sql = "insert into students (name,gender,age,class) values(?,?,?,?)";
        int update = jdbcTemplate.update(sql, "John Doe", "male", 20, "Class A");
        System.out.println(update);
        //2.查询数据
        sql="select * from students where id=?";
        List<Student> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class),1);
        System.out.println(query);

    }
    /**
     * 这是完成三层架构后的测试，也就是这个小练习结束的测试
     */
    @Test
    public void  testQueryAll(){
        //1.创建ioc容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-01.xml");
        //2.获取组件对象
        StudentController controller = context.getBean(StudentController.class);
        //3.使用组件
        controller.findAll();
        //4.关闭组件
        context.close();
    }
}

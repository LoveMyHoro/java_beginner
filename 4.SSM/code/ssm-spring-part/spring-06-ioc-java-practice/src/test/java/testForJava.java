import com.horo.config.javaConfiguration;
import com.horo.controller.StudentController;
import com.horo.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName testForJava
 * @Author iove
 * @Date 2024/9/29 下午3:56
 * @Version 1.0
 * @Description TODO
 **/

public class testForJava {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(javaConfiguration.class);
        StudentController controller = context.getBean(StudentController.class);
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        String sql = "select id , name , age , gender , class as classes from students where id=1;";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println(studentList);
    }
}

import com.alibaba.druid.pool.DruidDataSource;
import com.horo.config.javaConfiguration;
import com.horo.ioc_01_配置类方式管理Bean.StudentController;
import com.horo.ioc_01_配置类方式管理Bean.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * @ClassName testFotAnnotation
 * @Author iove
 * @Date 2024/9/29 上午8:46
 * @Version 1.0
 * @Description TODO
 **/
@SpringJUnitConfig(value = {javaConfiguration.class})  //指定配置类，不再需要直接获取容器
public class testFotAnnotation {

    //
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testIoc1() {
        String sql = "select id , name , age , gender , class as classes from students where id=1;";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println(studentList);
    }
}

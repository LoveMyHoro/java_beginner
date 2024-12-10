import com.horo.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springIocTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        StudentController controller = context.getBean(StudentController.class);
        controller.findAll();
    }
}

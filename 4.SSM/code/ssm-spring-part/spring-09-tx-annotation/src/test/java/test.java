import com.horo.config.javaConfig;
import com.horo.service.StudentService;
import com.horo.service.TopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @ClassName test
 * @Author iove
 * @Date 2024/10/5 下午8:17
 * @Version 1.0
 * @Description TODO
 **/
@SpringJUnitConfig(javaConfig.class)
public class test {
    @Autowired
    private StudentService studentService;

    @Autowired
    private TopService topService;
    @Test
    public void test() {
        topService.topService();
    }
}

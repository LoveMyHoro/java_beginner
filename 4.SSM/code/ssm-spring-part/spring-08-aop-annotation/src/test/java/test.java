import com.horo.config.javaConfig;
import com.horo.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @ClassName test
 * @Author iove
 * @Date 2024/10/5 下午3:23
 * @Version 1.0
 * @Description TODO
 **/
@SpringJUnitConfig(value = javaConfig.class)
public class test {
    @Autowired
    private Calculator calculator;
    @Test
    public void test() {
        int add = calculator.add(1, 2);
        System.out.println("add = " + add);
    }
}

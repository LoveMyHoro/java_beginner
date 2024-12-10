import com.horo.mapper.CustomerMapper;
import com.horo.mapper.OrderMapper;
import com.horo.pojo.Customer;
import com.horo.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName test
 * @Author iove
 * @Date 2024/10/11 下午6:01
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
    public void testForOne() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderById(1);
        System.out.println("order为="+order);
        System.out.println("order的customer为="+order.getCustomer());
    }
    @Test
    public void testForMany() {
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        List<Customer> customers = customerMapper.queryList();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    // junit会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void end() {
        session.commit();
        session.commit();
    }
}

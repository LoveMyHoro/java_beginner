import com.horo.mapper.UserMapper;
import com.horo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName test
 * @Author iove
 * @Date 2024/10/11 上午9:14
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
    public void InsertTest() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int insert = userMapper.insert(user);
        System.out.println(user);
        System.out.println(insert);
    }
    @Test
    public void SelectTest() {
        UserMapper userMapper= session.getMapper(UserMapper.class);

        System.out.println("查询结果="+userMapper.selectById(6));
    }
    @Test
    public void UpdateTest() {
        User user = new User();
        user.setId(6);
        user.setUsername("admin666");
        user.setPassword("123456");
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int update = userMapper.update(user);
        System.out.println("更新后的结果="+user);

    }
    // junit会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void end() {
        session.commit();
        session.commit();
    }
}

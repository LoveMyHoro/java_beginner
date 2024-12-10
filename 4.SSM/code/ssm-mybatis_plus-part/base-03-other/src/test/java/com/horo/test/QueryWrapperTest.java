package com.horo.test;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.horo.mapper.UserMapper;
import com.horo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @ClassName WrapperTest
 * @Author iove
 * @Date 2024/10/26 下午9:31
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootTest
public class QueryWrapperTest {
    @Autowired
    private UserMapper userMapper;
    //1.1.queryWrapper普通查询
    @Test
    public void test_01(){
        //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        //SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,id ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //这种链式连接标识语句之间是and连接，如果要or连接要用.or()，然后后面再拼接语句
        queryWrapper.like("name","a").between("age",20,30).isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }
    //1.2.queryWrapper排序查询
    @Test
    public void test_02(){
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        //SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,id ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }
    //1.3.queryWrapper指定列映射查询：
    //用map接值
    @Test
    public void test_05(){
        //查询用户信息的username和age字段
        //SELECT username,age FROM t_user
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }
    //1.4.queryWrapper条件查询（判断条件拼接）
    @Test
    public void test_06(){
        //拼接condition判断
        //每个条件拼接方法都condition参数,这是一个比较运算,为true追加当前条件!
        //eq(condition,列名,值)
        String name="root";
        Integer age=20;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(!StringUtils.isEmpty(name),"name",name).eq(age>1,"age",age);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }
    //2.queryWrapper删除
    @Test
    public void test_03(){
        //删除email为空的用户
        //DELETE FROM t_user WHERE (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("受影响行数="+result);
    }
    //3.queryWrapper修改
    @Test
    public void test_04(){
        //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE username LIKE ? AND age > ? OR email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a").gt("age",20).or().isNull("email");
        User user = new User();
        user.setAge(18);
        user.setEmail("a@qq.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("受影响行数="+result);
    }
    // 4.queryWrapper 插入
    @Test
    public void test_07() {
        User newUser = new User();
        newUser.setName("newUser");
        newUser.setAge(25);
        newUser.setEmail("newuser@example.com");
        int result = userMapper.insert(newUser);
        System.out.println("插入受影响行数=" + result);
    }
}

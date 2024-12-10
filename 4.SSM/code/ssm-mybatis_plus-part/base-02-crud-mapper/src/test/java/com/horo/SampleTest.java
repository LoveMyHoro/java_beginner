package com.horo;

import com.horo.mapper.UserMapper;
import com.horo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest //springboot下测试环境注解
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    //1.查询
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        //批量查询
        List<Long>ids=new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<User> users = userMapper.selectBatchIds(ids);
        System.out.println("users:" + users);
    }
    //2.插入
    @Test
    public void testInsert() {
        System.out.println("----- testInsert method ------");
        User user = new User();
        user.setName("明日香");
        user.setAge(18);
        user.setEmail("859321454@qq.com");
        userMapper.insert(user);
    }
    //3.删除
    @Test
    public void testDelete() {
        System.out.println("----- testDelete method ------");
        //1.根据id删除
        int rows = userMapper.deleteById(1850012283230740481L);
        System.out.println("rows"+rows);
        //2.根据map里的属性删除，
        Map param=new HashMap();
        param.put("age",20);
        int i = userMapper.deleteByMap(param);
        System.out.println("rows"+i);
    }
    //4.修改
    @Test
    public void testUpdate() {
        System.out.println("----- testUpdate method ------");
        User user = new User();
        user.setId(1850012605961338882L);
        user.setName("Asuka");
        user.setAge(18);
        user.setEmail("859321454@qq.com");
        int rows = userMapper.updateById(user);
        System.out.println("rows"+rows);
    }
}

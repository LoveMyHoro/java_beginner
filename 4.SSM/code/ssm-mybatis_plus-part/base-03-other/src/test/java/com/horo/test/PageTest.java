package com.horo.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.horo.mapper.UserMapper;
import com.horo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName com.horo.test.MyBatisTest
 * @Author iove
 * @Date 2024/10/26 下午7:57
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootTest
public class PageTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,3);
        //这个是自定义的page查询 方法
        userMapper.queryByAge(page,21);
        System.out.println("currentPage="+page.getCurrent());
        System.out.println("size="+page.getSize());
        System.out.println("records="+page.getRecords());//当前页的数据
        System.out.println("total="+page.getTotal());//总条数
    }
}

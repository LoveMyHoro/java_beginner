package com.horo.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.horo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName UpdateWapperTest
 * @Author iove
 * @Date 2024/10/26 下午11:46
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootTest
public class UpdateWrapperTest {
    @Autowired
    private UserMapper userMapper;
    //一般是LambdaQueryWrapper用的多
    @Test
    public void testUpdateWrapper() {
        //UpdateWrapper修改特点
        //1.直接携带修改的数据 set("列名","值")
        //2.指定任意修改值 如set("列名",null)，值设为空

    }
}

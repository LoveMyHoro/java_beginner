package com.horo.ioc_01_配置类方式管理Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName studentController
 * @Author iove
 * @Date 2024/9/29 上午8:42
 * @Version 1.0
 * @Description TODO
 **/
@Component
public class StudentController {
    @Autowired
    private StudentService studentService;

}

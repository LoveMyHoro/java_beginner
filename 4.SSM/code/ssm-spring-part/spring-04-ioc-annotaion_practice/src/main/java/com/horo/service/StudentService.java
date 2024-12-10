package com.horo.service;

import com.horo.pojo.Student;

import java.util.List;

//接口
public interface StudentService {

    /**
     * 查询全部学员业务
     * @return
     */
    List<Student> findAll();

}
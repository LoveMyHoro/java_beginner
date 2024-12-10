package com.horo.controller;

import com.horo.Student;
import com.horo.service.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService;
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    public void findAll(){
        List<Student> all = studentService.findAll();
        System.out.println("最终学员数据："+all);
    }
}

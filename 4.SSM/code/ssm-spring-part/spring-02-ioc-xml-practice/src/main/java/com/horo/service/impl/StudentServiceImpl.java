package com.horo.service.impl;

import com.horo.Student;
import com.horo.dao.StudentDao;
import com.horo.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    @Override
    public List<Student> findAll() {
        List<Student> students = studentDao.queryAll();
        System.out.println("studentServiceImpl:" + students);
        return students;
    }
}

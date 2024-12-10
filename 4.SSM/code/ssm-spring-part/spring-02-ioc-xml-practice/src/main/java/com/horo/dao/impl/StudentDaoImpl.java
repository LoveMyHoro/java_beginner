package com.horo.dao.impl;

import com.horo.Student;
import com.horo.dao.StudentDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;
    //这里会在xml中赋值
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Student> queryAll() {
        String sql = "select id,name,gender,age,class as classes from students";
        List<Student> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("StudentDaoImpl.queryAll(): " + query);
        return query;
    }
}

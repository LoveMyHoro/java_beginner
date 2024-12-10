package com.horo.service;

import com.horo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;


    @Transactional//添加了事物
    public void changeInfo(){
        studentDao.updateAgeById(10,1);
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeAge(){
        studentDao.updateAgeById(98,1);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeName(){
        studentDao.updateNameById("明日香",1);
    }
}
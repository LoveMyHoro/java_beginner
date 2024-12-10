package com.horo.controller;

import com.horo.pojo.Employee;
import com.horo.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName EmployeeController
 * @Author iove
 * @Date 2024/10/22 下午11:11
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/findAll")
    public List<Employee> getEmployeeService() {
        return employeeService.queryAllEmployee();
    }
}

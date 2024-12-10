package com.horo.service.impl;

import com.horo.mapper.EmployeeMapper;
import com.horo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmployeeService
 * @Author iove
 * @Date 2024/10/22 下午11:04
 * @Version 1.0
 * @Description TODO
 **/
@Service
public class EmployeeService implements com.horo.service.EmployeeService {
    @Autowired//自动装载
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> queryAllEmployee() {
        List<Employee> employeeList = employeeMapper.queryAllEmployee();
        return employeeList;
    }
}

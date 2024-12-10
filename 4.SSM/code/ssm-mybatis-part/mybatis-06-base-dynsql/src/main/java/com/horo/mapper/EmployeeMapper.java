package com.horo.mapper;

import com.horo.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    List<Employee>query(@Param("name")String name,@Param("salary")Double salary);

    int update(Employee employee);

    //批量操作foreach标签
    //1.批量查询
    //要记得加上@param注解为参数起别名，才能被xml文件识别
    List<Employee> queryBatch(@Param("ids")List<Integer> ids);

    //2.批量插入
    int insertBatch(@Param("list")List<Employee> employeeList);

    //3.批量更新
    int updateBatch(@Param("list")List<Employee> employeeList);
}

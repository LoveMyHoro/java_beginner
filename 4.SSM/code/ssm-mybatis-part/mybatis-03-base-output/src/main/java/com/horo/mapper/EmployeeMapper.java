package com.horo.mapper;

import com.horo.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    //1.一般的dml语句(插入，修改，删除)：返回类型默认是Integer
    Integer deleteById(Integer id);

    //2.查询语句：指定返回类型
    String queryNameById(Integer id);

    //3.查询语句：返回单个实体类
    Employee queryEmployeeById(Integer id);

    //4.查询多个结果，利用map接值
    //当我们没有实体类可以用来接值时，可以利用map来接收数据
    //key->查询的列
    //value->查询的值
    Map<String,Object> selectEmpNameAndMaxSalary();

    //5：查询所有的值，返回list集合
    List<Employee> queryAll();

    //6.主键回显
    int insert(Employee employee);

    //7.非自增长主键回显
    int insert2(Employee employee);

}

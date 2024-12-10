package com.horo.mapper;


import com.horo.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * t_emp表对应数据库SQL语句映射接口!
 *    接口只规定方法,参数和返回值!
 *    mapper.xml中编写具体SQL语句!
 */
public interface EmployeeMapper {

    /**
     * 根据员工id查询员工数据方法
     * @param empId  员工id
     * @return 员工实体对象
     */
    Employee queryById(int empId);

    Integer deleteById(int empId);

    //插入员工数据
    Integer insertEmp(Employee employee);

    //按照姓名和工资查询数据
    Integer queryByAll(@Param("id")int id, @Param("name")String name);

    //根据map类型插入数据
    Integer insertByMap(Map data);

    
}
package com.horo.mapper;

import com.horo.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpMapper
 * @Author iove
 * @Date 2025/1/29 下午9:21
 * @Version 1.0
 * @Description TODO
 **/

public interface EmpMapper {
	public List<Emp> getAllEmp();

	public List<Emp>getByResultMap();

	public Emp getEmpAndDeptOne(@Param("eid") int eid);
	public Emp getEmpAndDeptTwo(@Param("eid") int eid);
	public Emp getEmpAndDeptThree(@Param("eid") int eid);

	public List<Emp>getDeptAndEmpByStepTwo(@Param("did") int did);
}

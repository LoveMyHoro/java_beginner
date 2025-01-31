package com.horo.mapper;

import com.horo.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DeptMapper
 * @Author iove
 * @Date 2025/1/29 下午9:21
 * @Version 1.0
 * @Description TODO
 **/

public interface DeptMapper {
	public Dept getEmpAndDeptByStepTwo(@Param("did") int did);

	public Dept getDeptAndEmp(@Param("did") int did);

	public Dept getDeptAndEmpByStepOne(@Param("did") int did);
}

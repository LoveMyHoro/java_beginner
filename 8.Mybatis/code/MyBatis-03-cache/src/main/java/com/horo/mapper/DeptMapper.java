package com.horo.mapper;

import com.horo.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
	Dept getDeptById(@Param("did") int did);
}

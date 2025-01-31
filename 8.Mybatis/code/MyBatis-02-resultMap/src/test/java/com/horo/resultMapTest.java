package com.horo;

import com.horo.mapper.DeptMapper;
import com.horo.mapper.EmpMapper;
import com.horo.pojo.Dept;
import com.horo.pojo.Emp;
import com.horo.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

/**
 * @ClassName resultMapTest
 * @Author iove
 * @Date 2025/1/29 下午9:22
 * @Version 1.0
 * @Description TODO
 **/

public class resultMapTest {
	@Test
	public void test() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		List<Emp> allEmp = empMapper.getAllEmp();
		allEmp.forEach(emp-> System.out.println(emp));
	}
	//测试resultMap
	@Test
	public void test1() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		List<Emp> byResultMap = empMapper.getByResultMap();
		byResultMap.forEach(emp-> System.out.println(emp));
	}
	//测试resultMap多对一自定义映射关系
	@Test
	public void test2() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		//Emp emp = empMapper.getEmpAndDeptOne(1);
		//Emp emp = empMapper.getEmpAndDeptTwo(1);
		Emp emp = empMapper.getEmpAndDeptThree(1);
		System.out.println(emp.getEmpName());
		System.out.println(emp.getDept());
	}
	//测试resultMap一对多自定义映射关系
	@Test
	public void test3() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
		Dept dept= deptMapper.getEmpAndDeptByStepTwo(1);
		System.out.println(dept);
	}
	//测试resultMap一对多分布映射
	@Test
	public void test4() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
		Dept dept= deptMapper.getDeptAndEmpByStepOne(1);
		System.out.println(dept);
	}
}

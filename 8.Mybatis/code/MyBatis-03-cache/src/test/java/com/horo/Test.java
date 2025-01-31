package com.horo;

import com.horo.mapper.DeptMapper;
import com.horo.mapper.EmpMapper;
import com.horo.pojo.Dept;
import com.horo.pojo.Emp;
import com.horo.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName Test
 * @Author iove
 * @Date 2025/1/30 下午7:33
 * @Version 1.0
 * @Description TODO
 **/

public class Test {
	@org.junit.Test
	public void test() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		List<Emp> allEmp = empMapper.getAllEmp();
		allEmp.forEach(emp-> System.out.println(emp));
	}
	//1.验证一级缓存
	@org.junit.Test
	public void CacheLevelOne() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
		Dept dept=deptMapper.getDeptById(1);
		Dept dept2=deptMapper.getDeptById(1);
		System.out.println(dept);
		System.out.println(dept2);
	}
	//2.验证二级缓存
	@org.junit.Test
	public void CacheLevelTwo() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSessionOne = sqlSessionFactory.openSession(true);
		SqlSession sqlSessionTwo = sqlSessionFactory.openSession(true);
		DeptMapper deptMapper1 = sqlSessionOne.getMapper(DeptMapper.class);
		DeptMapper deptMapper2 = sqlSessionTwo.getMapper(DeptMapper.class);
		Dept dept1=deptMapper1.getDeptById(1);
		System.out.println(dept1);
		sqlSessionOne.close();//必须关闭sqlSession二级缓存才能生效
		Dept dept2=deptMapper2.getDeptById(1);
		System.out.println(dept2);
		sqlSessionTwo.close();
	}

}

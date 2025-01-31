package com.horo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.horo.mapper.DeptMapper;
import com.horo.pojo.Dept;
import com.horo.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName PageHelpTest
 * @Author iove
 * @Date 2025/1/31 下午3:51
 * @Version 1.0
 * @Description TODO
 **/

public class PageHelperTest {
	@Test
	public void testForPageHelper() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
		Page<Object>page=PageHelper.startPage(5,5);
		List<Dept> deptList=deptMapper.selectAll();
		System.out.println(page);
		PageInfo<Dept> pageInfo=new PageInfo<>(deptList,5);//5表示导航栏显示的页数
		System.out.println(pageInfo);
	}
}

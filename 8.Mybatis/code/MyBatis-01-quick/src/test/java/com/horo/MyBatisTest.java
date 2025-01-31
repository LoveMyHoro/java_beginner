package com.horo;

import com.horo.mapper.UserMapper;
import com.horo.pojo.User;
import com.horo.utils.SqlSessionUtil;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MyBatisTest
 * @Author iove
 * @Date 2025/1/27 下午5:03
 * @Version 1.0
 * @Description TODO
 **/
public class MyBatisTest {
	/**
	 * 1.不通过工具类直接访问
	 * @throws IOException
	 */
	@Test
	public void test1() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//这里的是设置自动提交
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user=new User("Asuka","123456",12,"女","859321454@qq.com");
		//int result = userMapper.insertUser();
		//int result=userMapper.deleteUser();
		//int result=userMapper.updateUser();]
		List<User> userLis = userMapper.getAllUser();
		userLis.forEach(user1 -> System.out.println(user1));
		sqlSession.close();
	}
	@Test
	public void test2(){
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userLis = userMapper.getAllUser();
		userLis.forEach(user1 -> System.out.println(user1));
		sqlSession.close();
	}
	//利用map接收返回值
	@Test
	public void test3(){
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<Map<String, Object>> allUsersByMap = userMapper.getAllUsersToMap();
		allUsersByMap.forEach(userMap-> System.out.println(userMap));
	}
	//模糊查询
	@Test
	public void test4(){
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User asu = userMapper.getUserByLike("Asu");
		System.out.println(asu);
	}
	//in批量删除
	@Test
	public void test5(){
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Integer result = userMapper.deleteUserByIn("1,2,3");
		System.out.println(result);
	}
	//主键回显
	@Test
	public void test6(){
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user=new User("daifuyang","123456",22,"男","111");
		userMapper.insertUser(user);
		System.out.println("主键回显的id："+user.getId());
	}

}

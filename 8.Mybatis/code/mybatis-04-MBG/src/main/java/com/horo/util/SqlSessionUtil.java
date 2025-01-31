package com.horo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName SqlSessionUtil
 * @Author iove
 * @Date 2025/1/27 下午9:03
 * @Version 1.0
 * @Description TODO
 **/

public class SqlSessionUtil {
	public static SqlSession getSqlSession() {
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			return sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

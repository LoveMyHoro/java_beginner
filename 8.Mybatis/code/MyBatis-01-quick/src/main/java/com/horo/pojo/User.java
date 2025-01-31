package com.horo.pojo;

import lombok.Data;

/**
 * @ClassName user
 * @Author iove
 * @Date 2025/1/27 下午2:50
 * @Version 1.0
 * @Description TODO
 **/
@Data
public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer age;
	private String sex;
	private String email;

	public User() {
	}

	public User(String username, String password, Integer age, String sex, String email) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.email = email;
	}
}

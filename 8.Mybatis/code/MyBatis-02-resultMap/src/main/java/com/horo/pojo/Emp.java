package com.horo.pojo;

import lombok.Data;

/**
 * @ClassName emp
 * @Author iove
 * @Date 2025/1/29 下午9:18
 * @Version 1.0
 * @Description TODO
 **/
@Data
public class Emp {
	private int eid;
	private String empName;
	private int age;
	private char sex;
	private String email;
	private int did;
	private Dept dept;

	public Emp() {
	}

	public Emp(int eid, String empName, int age, char sex, String email, int did, Dept dept) {
		this.eid = eid;
		this.empName = empName;
		this.age = age;
		this.sex = sex;
		this.email = email;
		this.did = did;
		this.dept = dept;
	}
}

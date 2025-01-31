package com.horo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Dept
 * @Author iove
 * @Date 2025/1/29 下午9:20
 * @Version 1.0
 * @Description TODO
 **/
@Data
public class Dept implements Serializable {
	private int did;
	private String deptName;
	private List<Emp>emps;

	public Dept() {
	}

	public Dept(int did, String deptName, List<Emp> emps) {
		this.did = did;
		this.deptName = deptName;
		this.emps = emps;
	}
}

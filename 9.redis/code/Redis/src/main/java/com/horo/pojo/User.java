package com.horo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Author iove
 * @Date 2025/2/2 下午3:57
 * @Version 1.0
 * @Description TODO
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String username;
	private String password;
	private Integer age;
}

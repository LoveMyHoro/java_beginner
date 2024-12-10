package com.horo.vo;

import lombok.Data;

/**
 * @ClassName UpdatePasswordVo
 * @Author iove
 * @Date 2024/11/16 上午10:42
 * @Version 1.0
 * @Description TODO
 **/
@Data
public class UpdatePwdVo {
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
}

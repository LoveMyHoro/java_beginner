package com.horo.vo;

import lombok.Data;

/**
 * @ClassName updatePwdVo
 * @Author iove
 * @Date 2024/11/1 下午11:20
 * @Version 1.0
 * @Description TODO
 **/
@Data
public class UpdatePwdVo {
    private String old_pwd;
    private String new_pwd;
    private String re_pwd;
}

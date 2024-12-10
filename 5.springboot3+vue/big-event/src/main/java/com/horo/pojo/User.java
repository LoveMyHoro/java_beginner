package com.horo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


/**
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    @NotNull
    private Integer id;

    private String username;
    @JsonIgnore//返回json时忽略这个属性
    private String password;

    @NotNull
    @Pattern(regexp = "[^\s]{1,10}")
    private String nickname;
    @NotNull
    @Email
    private String email;

    private String userPic;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
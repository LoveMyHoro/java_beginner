package com.horo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.horo.anno.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

/**
 * @TableName article
 */
@TableName(value ="article")
@Data
public class Article implements Serializable {
    private Integer id;

    @Pattern(regexp = "[^\s]{1,10}")
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @URL
    @NotEmpty
    private String coverImg;
    @NotEmpty
    @State
    private String state;
    @NotNull
    private Integer categoryId;
    @JsonIgnore
    private Integer createUser;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
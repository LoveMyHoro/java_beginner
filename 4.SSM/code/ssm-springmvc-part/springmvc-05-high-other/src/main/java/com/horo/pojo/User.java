package com.horo.pojo;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * @ClassName User
 * @Author iove
 * @Date 2024/10/21 上午10:51
 * @Version 1.0
 * @Description TODO
 **/
@Data
public class User {
    @NotBlank
    private String name;
    @Length(min = 6)
    private String password;
    @Min(1)
    private int age;
    @Email
    private String email;
    @Past
    private Date birthday;
}

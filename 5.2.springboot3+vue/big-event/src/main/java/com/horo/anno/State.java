package com.horo.anno;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import validation.StateValidation;

import java.lang.annotation.*;

@Documented//元注解，标识这个自定义注解可以抽取到帮助文档中
@Constraint(//指定将来谁来为这个注解提供校验规则。提供校验规则的类放在validation包内
        validatedBy = {StateValidation.class}
)
@Target({ElementType.FIELD})//元注解，标识这个自定义注解可以放到哪些地方：是属性上，方法上还是其他地方
@Retention(RetentionPolicy.RUNTIME)//元注解，标识这个自定义注解可以保存到什么时候
public @interface State {
    //message提供校验失败后提示的信息
    String message() default "state参数的值只能是已发布的值或者草稿";
    //指定分组
    Class<?>[] groups() default {};
    //负载，获取到state注解的附加信息。一般用不着
    Class<? extends Payload>[] payload() default {};
}

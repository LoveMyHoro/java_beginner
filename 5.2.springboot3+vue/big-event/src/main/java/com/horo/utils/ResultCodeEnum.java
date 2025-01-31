package com.horo.utils;

/**
 * 统一返回结果状态信息类
 *
 */
public enum ResultCodeEnum {

    SUCCESS(0,"操作成功"),
    USERNAME_ERROR(-1,"usernameError"),
    PASSWORD_ERROR(-1,"passwordError"),
    NOTLOGIN(-1,"notLogin"),
    USERNAME_USED(-1,"userNameUsed");

    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}

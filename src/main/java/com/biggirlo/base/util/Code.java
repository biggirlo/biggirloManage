package com.biggirlo.base.util;

/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 * 系统返回码枚举类
 * @author 王雁欣
 * create on 2017/9/19 23:42
 */
public enum Code {
    SUCCESS(10000, "成功"),
    UN_LOGIN(10002, "未登陆"),
    SYSTEM_ERROR(10001, "系统错误"),
    LOGIN_ERROR_UN_EXIST_NAME_PASSWORD(10003,"用户名或者密码为空"),
    LOGIN_ERROR_FALIE_NAME_PASSWORD(10004,"用户名或者密码为错误"),
    REPEAT_KEYWORK(2000,"重复关键字"),
    FORBIDDEN(10403,"无权限访问");
    private long code;
    private String msg;

    Code(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回值
     *
     * @return
     */
    public long value() {
        return this.code;
    }

    /**
     * 返回信息
     *
     * @return
     */
    public String msg() {
        return this.msg;
    }

}
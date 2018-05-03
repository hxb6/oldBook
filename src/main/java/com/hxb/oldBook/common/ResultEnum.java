package com.hxb.oldBook.common;

/**
 * @Package: com.hxb.oldBook.fragment
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/25 13:29
 * @Description: 保存返回状态和提示信息的枚举类
 **/
public enum ResultEnum {

    SUCCESS(1,"请求成功"),
    SUCCESS_NULL(1,"请求成功,但暂无相关数据"),
    REGISTER_SUCCESS(1,"注册成功"),
    ERROR(-1,"未知错误"),
    ALREADY_REGISTER(2,"该用户已经注册"),
    ACCOUNT_PASSWORD_ERROR(3,"用户或密码错误"),
    ACCOUNT_NOT_VALID(4,"该账号已被管理员限制使用"),
    OLD_PASSWORD_ERROR(5,"旧密码错误");

    /**
     * 返回的状态码
     */
    private Integer status;

    /**
     * 返回提示信息
     */
    private String message;

    /**
     * 枚举构造函数
     * @param status 返回状态
     */
    ResultEnum(Integer status,String message){
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

package com.hxb.oldBook.common;

/**
 * @Package: com.hxb.oldBook.common
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/25 13:29
 * @Description: 保存返回状态和提示信息的枚举类
 **/
public enum ResultEnum {

    /**
     * 请求成功
     */
    SUCCESS(1,"请求成功"),

    /**
     * 请求成功,数据库中无相关数据
     */
    SUCCESS_NULL(1,"请求成功,但暂无相关数据"),
    /**
     * 未知错误
     */
    ERROR(-1,"未知错误");

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

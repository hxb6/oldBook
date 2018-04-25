package com.hxb.oldBook.common;

/**
 * @Package: com.hxb.oldBook.common
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/25 13:29
 * @Description: 返回状态的枚举
 **/
public enum ResultEnum {

    /**
     * 相应成功
     */
    SUCCESS(1),
    /**
     * 相应失败
     */
    ERROR(-1);

    /**
     * 返回的状态码
     */
    private Integer status;

    /**
     * 枚举构造函数
     * @param status 返回状态
     */
    ResultEnum(Integer status){
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}

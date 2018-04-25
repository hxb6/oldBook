package com.hxb.oldBook.common;

/**
 * @Package: com.hxb.oldBook.resultbean
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/25 12:15
 * @Description:返回信息进行统一格式封装
 **/
public class Result<T> {

    /**
     * 返回状态 1-成功 其他均为失败
     */
    private Integer status;

    /**
     * 返回提示信息
     */
    private String message;

    /**
     * 返回的数据,使用泛型兼容不同的类型
     */
    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}





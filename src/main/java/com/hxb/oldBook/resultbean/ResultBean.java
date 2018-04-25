package com.hxb.oldBook.resultbean;

/**
 * @Package: com.hxb.oldBook.resultbean
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/25 12:15
 * @Description:返回信息进行统一格式封装
 **/
public class ResultBean {

    /**
     * 返回状态
     */
    private Integer status;

    /**
     * 返回提示信息
     */
    private String message;

    /**
     * 返回数据封装
     */
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

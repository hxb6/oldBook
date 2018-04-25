package com.hxb.oldBook.exception;

import com.hxb.oldBook.common.ResultEnum;

/**
 * @Package: com.hxb.oldBook.exception
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/25 17:01
 * @Description: 自定义异常
 **/
public class CustomException extends RuntimeException{

    /**
     * 错误状态
     */
    private Integer status;


    public CustomException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.status = resultEnum.getStatus();
    }

    public Integer getStatus() {
        return status;
    }



}

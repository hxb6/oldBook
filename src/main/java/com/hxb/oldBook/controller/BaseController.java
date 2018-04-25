package com.hxb.oldBook.controller;


import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.resultbean.ResultBean;

/**
 * @Package: com.hxb.oldBook.controller
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/25 13:10
 * @Description:
 **/
public class BaseController {

    /**
     * 返回的格式封装对象
     */
    private ResultBean resultBean = null;

    /**
     * 相应成功时设置相应的相应状态,提示信息和数据
     * @param message 提示信息
     * @param object 数据
     * @return 格式的封装
     */
    public final synchronized ResultBean ajaxSuccessMessage(String message,Object object){
        setMessageAndData(message, object);
        resultBean.setStatus(ResultEnum.SUCCESS.getStatus());
        return resultBean;
    }

    /**
     * 相应失败时设置相应的相应状态,提示信息和数据
     * @param message 提示信息
     * @param object 数据
     * @return 格式的封装
     */
    public final synchronized ResultBean ajaxErrorMessage(String message,Object object){
        setMessageAndData(message, object);
        resultBean.setStatus(ResultEnum.ERROR.getStatus());
        return resultBean;
    }

    /**
     * 抽取的公用方法 实例化resultBean并设置提示信息和数据
     * @param message 提示信息
     * @param object 数据
     */
    private void setMessageAndData(String message, Object object) {
        resultBean = new ResultBean();
        resultBean.setMessage(message);
        resultBean.setData(object);
    }
}

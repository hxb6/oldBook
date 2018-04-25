package com.hxb.oldBook.utils;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;

/**
 * @Package: com.hxb.oldBook.utils
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/25 17:21
 * @Description: 返回结果工具类
 **/
public class ResultUtil {

    /**
     * 请求成功时自定义设置相应的相应状态,提示信息和数据
     * @param message 提示信息
     * @param object 数据
     * @return 格式的封装
     */
    public static  Result success(String message, Object object){
        Result result = setMessageAndData(message, object);
        result.setStatus(ResultEnum.SUCCESS.getStatus());
        return result;
    }

    /**
     * 请求成功时根据ResultEnum设置相应的相应状态,提示信息和数据
     * @param resultEnum 提示信息
     * @param object 数据
     * @return 格式的封装
     */
    public static  Result success(ResultEnum resultEnum, Object object){
        Result result = setMessageAndData(resultEnum.getMessage(), object);
        result.setStatus(resultEnum.getStatus());
        return result;
    }

    /**
     * 请求成功时(无数据)根据ResultEnum设置相应的相应状态,提示信息和数据
     * @param resultEnum 提示信息
     * @return 格式的封装
     */
    public static  Result success(ResultEnum resultEnum){
        return success(resultEnum, null);
    }

    /**
     * 相应出错时自定义设置相应的相应状态,提示信息和数据
     * @param message 提示信息
     * @param object 数据
     * @return 格式的封装
     */
    public static  Result error(String message, Object object){
        Result result = setMessageAndData(message, object);
        result.setStatus(ResultEnum.ERROR.getStatus());
        return result;
    }

    /**
     * 相应出错(知道错误类型)时设置相应的相应状态,提示信息和数据
     * @param resultEnum 提示信息
     * @return 格式的封装
     */
    public static Result error(ResultEnum resultEnum){
        Result result = setMessageAndData(resultEnum.getMessage(), resultEnum.getStatus());
        result.setStatus(ResultEnum.ERROR.getStatus());
        return result;
    }

    /**
     * 抽取的公用方法 实例化resultBean并设置提示信息和数据
     * @param message 提示信息
     * @param object 数据
     */
    private static Result setMessageAndData(String message, Object object) {
        Result result = new Result();
        result.setMessage(message);
        result.setData(object);
        return result;
    }
}

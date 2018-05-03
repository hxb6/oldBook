package com.hxb.oldBook.exception;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.hxb.oldBook.exception
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/25 17:17
 * @Description: 统一异常处理
 **/
@ControllerAdvice
public class HandleException {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result unifiedHandleException(Exception e){
        /*
        用户自定义的异常处理
         */
        if(e instanceof CustomException){
            CustomException customException = ((CustomException) e);
            return ResultUtil.error(customException);
        }

        /*
         系统异常
         */
        return ResultUtil.error(ResultEnum.ERROR);
    }

}

package com.hxb.oldBook.utils;

import org.springframework.util.ResourceUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;

/**
 * @Package: com.hxb.oldBook.utils
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/4 16:56
 * @Description: 得到request及session相关信息工具类
 **/
public class RequestUtil {

    /**
     * 从上下文获取请求包装对象request
     * @return HttpServletRequest 实例
     */
    public static HttpServletRequest getRequest(){
        /*
            1.从RequestContextHolder中获取 RequestAttributes 对象
            2.再类型转换  将RequestAttributes接口转换为其实现类ServletRequestAttributes
            3.调用getRequest()获取HttpServletRequest对象实例
         */
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();
        return request;
    }

    /**
     * 获取会话session
     * @return HttpSession 会话session
     */
    public static HttpSession getSession(){
        HttpServletRequest request = getRequest();
        return request.getSession();
    }


}

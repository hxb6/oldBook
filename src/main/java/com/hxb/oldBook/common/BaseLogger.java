package com.hxb.oldBook.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: com.hxb.oldBook.common
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/25 16:18
 * @Description: log声明及创建 需要使用日志功能继承该类
 *                  不用每次都在类中定义
 **/
public  class BaseLogger {

    /**
     * 创建日志对象
     */
    protected final Logger logger = LoggerFactory.getLogger(BaseLogger.class);


}

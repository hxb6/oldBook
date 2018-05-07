package com.hxb.oldBook.utils;

import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.common.TablePageResult;

/**
 * @Package: com.hxb.oldBook.utils
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/7 22:17
 * @Description: 表格分页返回数据工具类
 **/
public class TablePageResultUtil {

    /**
     * 请求成功 返回数据
     * @param total 数据总数
     * @param object 数据
     * @return
     */
    public static TablePageResult success(Integer total,Object object){
        TablePageResult tablePageResult = new TablePageResult();
        tablePageResult.setTotal(total);
        tablePageResult.setRows(object);
        return tablePageResult;
    }
}

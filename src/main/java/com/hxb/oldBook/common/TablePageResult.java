package com.hxb.oldBook.common;

/**
 * @Package: com.hxb.oldBook.common
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/7 22:14
 * @Description: bootStrap table 表格分页 数据封装 必须包含当前页数和数据总数
 **/
public class TablePageResult<T> {

    /**
     * 数据总数
     */
    private Integer total;

    /**
     * 返回当前页的数据,使用泛型兼容不同的类型
     */
    private T rows;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }
}

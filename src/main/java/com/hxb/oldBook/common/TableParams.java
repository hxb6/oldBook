package com.hxb.oldBook.common;

import com.hxb.oldBook.utils.StringUtil;

/**
 * @Package: com.hxb.oldBook.common
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/9 15:39
 * @Description: bootstrap table表格传递的参数 包含分页信息 排序信息 以及字段相等与某个信息
 **/
public class TableParams<T> {

    /**
     * 从第几条数据开始查询
     */
    private Integer offset;

    /**
     * 查询几条数据
     */
    private Integer limit;

    /**
     * 排序字段
     */
    private String sortName;

    /**
     * 排序方式
     */
    private String sortOrder;

    /**
     * 数据查询时 sql语句中确定的某个字段要用来作为一定条件的判断，将其等于该参数参数  利用泛型匹配所有类型
     */
    private T target;

    /**
     * 购买订单还是售卖订单 0-购买订单 1-售卖订单
     */
    private int state;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = StringUtil.humpToUnderline(sortName);
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}

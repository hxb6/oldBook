package com.hxb.oldBook.common;

import com.hxb.oldBook.utils.StringUtil;

/**
 * @Package: com.hxb.oldBook.common
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/9 15:39
 * @Description: bootstrap table表格传递的参数 包含分页信息 排序信息
 **/
public class TableParams {

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


    @Override
    public String toString() {
        return "TableParams{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", sortName='" + sortName + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }
}

package com.hxb.oldBook.mapper;

import com.hxb.oldBook.pojo.BookVariety;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookVarietyMapper extends Mapper<BookVariety> {

    /**
     * 查询全部结果 按创建时间排序 最近创建的在前面
     *
     * @return
     */
    @Override
    List<BookVariety> selectAll();
}
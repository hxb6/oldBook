package com.hxb.oldBook.mapper;

import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.BookInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookInfoMapper extends Mapper<BookInfo> {

    List<BookInfo> getBooksByTableParams(@Param("tableParams") TableParams tableParams);
}
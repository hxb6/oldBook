package com.hxb.oldBook.mapper;

import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.BookInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookInfoMapper extends Mapper<BookInfo> {
    /**
     * 根据TableParams 对象进行分页和排序
     * @param tableParams
     * @param roleType 用户角色
     * @param userId 用户id
     * @return
     */
    List<BookInfo> getBooksByTableParams(@Param("tableParams") TableParams tableParams,
                                         @Param("roleType") short roleType,
                                         @Param("userId") Integer userId);


    /**
     * 设置售卖书籍上架与下架和假性删除(设置状态为3) 接口
     */
    void setBookOut(@Param("id") Integer id, @Param("bookStatus") Integer bookStatus);
}
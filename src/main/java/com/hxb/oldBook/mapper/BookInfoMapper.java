package com.hxb.oldBook.mapper;

import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.BookInfo;
import com.hxb.oldBook.pojo.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookInfoMapper extends Mapper<BookInfo> {
    /**
     * 根据TableParams 对象进行分页和排序
     * @param tableParams 表格参数
     * @param user 登录用户对象
     * @return
     */
    List<BookInfo> getBooksByTableParams(@Param("tableParams") TableParams tableParams,
                                         @Param("user") User user);


    /**
     * 设置售卖书籍上架与下架和假性删除(设置状态为3) 接口
     */
    void setBookOut(@Param("id") Integer id, @Param("bookStatus") Integer bookStatus);


    /**
     * 根据用户id查询用户没有删除的书籍数量
     * param user 登录用户对象
     * @return
     */
    int getCountByUserId(@Param("tableParams") TableParams tableParams,
                         @Param("user") User user);

    /**
     * 首页获取售卖的书籍 已上架的书籍并且该书籍所属的用户账号未被冻结
     *
     * @return
     */
    List<BookInfo> getSellBook();

    /**
     * 根据书籍类查询售卖的书籍
     * @param bookVarietyId
     * @return
     */
    List<BookInfo> getSellBookByBookVariety(@Param("bookVarietyId") Integer bookVarietyId);

    /**
     * 根据书籍名称模糊查询售卖的书籍
     * @param bookName
     * @return
     */
    List<BookInfo> getSellBookLikeBookName(@Param("bookName") String bookName);
}
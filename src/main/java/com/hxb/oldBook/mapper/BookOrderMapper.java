package com.hxb.oldBook.mapper;

import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.BookInfo;
import com.hxb.oldBook.pojo.BookOrder;
import com.hxb.oldBook.pojo.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookOrderMapper extends Mapper<BookOrder> {

    /**
     * 用户得到自己的订单
     * @param tableParams
     * @param user
     * @return
     */
    List<BookOrder> queryOrder(@Param("tableParams") TableParams tableParams,
                                @Param("user") User user);

    /**
     * 用户按条件查询自己的订单数量
     * @param tableParams
     * @param user
     * @return
     */
    int getOrderCount(@Param("tableParams") TableParams tableParams,
                      @Param("user") User user);

    /**
     * 管理员得到所有订单
     * @param tableParams
     * @return
     */
    List<BookOrder> getAll(@Param("tableParams") TableParams tableParams);

}
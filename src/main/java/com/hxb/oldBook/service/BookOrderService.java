package com.hxb.oldBook.service;

import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.BookOrder;
import com.hxb.oldBook.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package: com.hxb.oldBook.service
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 14:49
 * @Description: 订单接口
 **/
public interface BookOrderService extends BaseService<BookOrder> {

    /**
     * 创建订单
     *
     * @param bookId
     * @param bookNum
     */
    void createOrder(Integer bookId, Integer bookNum);

    /**
     * 用户得到自己的订单
     *
     * @param tableParams
     * @param user
     * @return
     */
    List<BookOrder> queryOrder(TableParams tableParams, User user);

    /**
     * 用户按条件查询自己的订单数量
     *
     * @param tableParams
     * @param user
     * @return
     */
    int getOrderCount(TableParams tableParams, User user);

    /**
     * 管理员得到所有订单
     *
     * @param tableParams
     * @return
     */
    List<BookOrder> getAll(TableParams tableParams);
}

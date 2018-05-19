package com.hxb.oldBook.service.impl;

import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.mapper.BookInfoMapper;
import com.hxb.oldBook.mapper.BookOrderMapper;
import com.hxb.oldBook.mapper.UserMapper;
import com.hxb.oldBook.pojo.BookInfo;
import com.hxb.oldBook.pojo.BookOrder;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.BookOrderService;
import com.hxb.oldBook.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Package: com.hxb.oldBook.service.impl
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 14:51
 * @Description:
 **/
@Service
public class BookOrderServiceImpl extends BaseServiceImpl<BookOrder> implements BookOrderService {

    @Autowired
    private BookOrderMapper bookOrderMapper;

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 创建订单
     *
     * @param bookId
     * @param bookNum
     */
    @Transactional
    @Override
    public void createOrder(Integer bookId, Integer bookNum) {
        System.out.println("书籍数量  "+bookNum);
        //获取书籍
        BookInfo bookInfo = bookInfoMapper.selectByPrimaryKey(bookId);
        //获取售卖商家
        User sellUser = userMapper.selectByPrimaryKey(bookInfo.getUserId());
        //获取登录用户设置为买家
        User buyUser = UserUtil.getUserFormSession();
        BookOrder bookOrder = new BookOrder();
        bookOrder.setBookId(bookId);
        bookOrder.setSellerId(sellUser.getId());
        bookOrder.setBuyersId(buyUser.getId());
        //设置创建时间和更新时间
        Date date = new Date();
        bookOrder.setOrderCreateTime(date);
        bookOrder.setOrderModifiedTime(date);
        bookOrder.setNum(bookNum);
        Double bookPrice = bookInfo.getBookPrice().doubleValue();
        Double allPrice = bookPrice * bookNum;
        bookOrder.setMoney(allPrice);
        //默认未支付
        bookOrder.setStatus(0);

        // 更新书籍数量 当书籍剩货为0时自动下架
        int num1 = bookInfo.getBookSave();
        int num2 = num1 - bookNum;
        if (num2 == 0) {
            bookInfo.setBookStatus(((short) 0));
        }
        bookInfo.setBookSave(((short) num2));
        bookInfoMapper.updateByPrimaryKeySelective(bookInfo);
        bookOrderMapper.insertSelective(bookOrder);
    }

    /**
     * 用户得到自己的订单
     *
     * @param tableParams
     * @param user
     * @return
     */
    @Override
    public List<BookOrder> queryOrder(TableParams tableParams, User user) {
        return bookOrderMapper.queryOrder(tableParams, user);
    }

    /**
     * 用户按条件查询自己的订单数量
     *
     * @param tableParams
     * @param user
     * @return
     */
    @Override
    public int getOrderCount(TableParams tableParams, User user) {
        return bookOrderMapper.getOrderCount(tableParams, user);
    }

    /**
     * 管理员得到所有订单
     *
     * @param tableParams
     * @return
     */
    @Override
    public List<BookOrder> getAll(TableParams tableParams) {
        return bookOrderMapper.getAll(tableParams);
    }
}

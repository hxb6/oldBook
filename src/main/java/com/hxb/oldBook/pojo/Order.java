package com.hxb.oldBook.pojo;

import java.util.Date;
import javax.persistence.*;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 卖家用户的id
     */
    @Column(name = "seller_id")
    private Integer sellerId;

    /**
     * 买家用户的id
     */
    @Column(name = "buyers_id")
    private Integer buyersId;

    /**
     * 售卖书籍的id
     */
    @Column(name = "book_id")
    private Integer bookId;

    /**
     * 订单创建时间
     */
    @Column(name = "order_create_time")
    private Date orderCreateTime;

    /**
     * 订单最近修改时间
     */
    @Column(name = "order_modified_time")
    private Date orderModifiedTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取卖家用户的id
     *
     * @return seller_id - 卖家用户的id
     */
    public Integer getSellerId() {
        return sellerId;
    }

    /**
     * 设置卖家用户的id
     *
     * @param sellerId 卖家用户的id
     */
    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取买家用户的id
     *
     * @return buyers_id - 买家用户的id
     */
    public Integer getBuyersId() {
        return buyersId;
    }

    /**
     * 设置买家用户的id
     *
     * @param buyersId 买家用户的id
     */
    public void setBuyersId(Integer buyersId) {
        this.buyersId = buyersId;
    }

    /**
     * 获取售卖书籍的id
     *
     * @return book_id - 售卖书籍的id
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * 设置售卖书籍的id
     *
     * @param bookId 售卖书籍的id
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * 获取订单创建时间
     *
     * @return order_create_time - 订单创建时间
     */
    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    /**
     * 设置订单创建时间
     *
     * @param orderCreateTime 订单创建时间
     */
    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    /**
     * 获取订单最近修改时间
     *
     * @return order_modified_time - 订单最近修改时间
     */
    public Date getOrderModifiedTime() {
        return orderModifiedTime;
    }

    /**
     * 设置订单最近修改时间
     *
     * @param orderModifiedTime 订单最近修改时间
     */
    public void setOrderModifiedTime(Date orderModifiedTime) {
        this.orderModifiedTime = orderModifiedTime;
    }
}
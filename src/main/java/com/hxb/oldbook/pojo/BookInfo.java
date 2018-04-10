package com.hxb.oldbook.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "book_info")
public class BookInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 书籍名称
     */
    @Column(name = "book_name")
    private String bookName;

    /**
     * 书籍价格
     */
    @Column(name = "book_price")
    private BigDecimal bookPrice;

    /**
     * 书籍剩货
     */
    @Column(name = "book_save")
    private Short bookSave;

    /**
     * 书籍简介 50字以内
     */
    @Column(name = "book_introduction")
    private String bookIntroduction;

    /**
     * 所属书籍分类的id
     */
    @Column(name = "book_varety_id")
    private Integer bookVaretyId;

    /**
     * 所属用户的id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 书籍信息创建时间
     */
    @Column(name = "book_create_time")
    private Date bookCreateTime;

    /**
     * 书籍信息最近修改时间
     */
    @Column(name = "book_modified-time")
    private Date bookModifiedTime;

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
     * 获取书籍名称
     *
     * @return book_name - 书籍名称
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 设置书籍名称
     *
     * @param bookName 书籍名称
     */
    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    /**
     * 获取书籍价格
     *
     * @return book_price - 书籍价格
     */
    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    /**
     * 设置书籍价格
     *
     * @param bookPrice 书籍价格
     */
    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    /**
     * 获取书籍剩货
     *
     * @return book_save - 书籍剩货
     */
    public Short getBookSave() {
        return bookSave;
    }

    /**
     * 设置书籍剩货
     *
     * @param bookSave 书籍剩货
     */
    public void setBookSave(Short bookSave) {
        this.bookSave = bookSave;
    }

    /**
     * 获取书籍简介 50字以内
     *
     * @return book_introduction - 书籍简介 50字以内
     */
    public String getBookIntroduction() {
        return bookIntroduction;
    }

    /**
     * 设置书籍简介 50字以内
     *
     * @param bookIntroduction 书籍简介 50字以内
     */
    public void setBookIntroduction(String bookIntroduction) {
        this.bookIntroduction = bookIntroduction == null ? null : bookIntroduction.trim();
    }

    /**
     * 获取所属书籍分类的id
     *
     * @return book_varety_id - 所属书籍分类的id
     */
    public Integer getBookVaretyId() {
        return bookVaretyId;
    }

    /**
     * 设置所属书籍分类的id
     *
     * @param bookVaretyId 所属书籍分类的id
     */
    public void setBookVaretyId(Integer bookVaretyId) {
        this.bookVaretyId = bookVaretyId;
    }

    /**
     * 获取所属用户的id
     *
     * @return user_id - 所属用户的id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置所属用户的id
     *
     * @param userId 所属用户的id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取书籍信息创建时间
     *
     * @return book_create_time - 书籍信息创建时间
     */
    public Date getBookCreateTime() {
        return bookCreateTime;
    }

    /**
     * 设置书籍信息创建时间
     *
     * @param bookCreateTime 书籍信息创建时间
     */
    public void setBookCreateTime(Date bookCreateTime) {
        this.bookCreateTime = bookCreateTime;
    }

    /**
     * 获取书籍信息最近修改时间
     *
     * @return book_modified-time - 书籍信息最近修改时间
     */
    public Date getBookModifiedTime() {
        return bookModifiedTime;
    }

    /**
     * 设置书籍信息最近修改时间
     *
     * @param bookModifiedTime 书籍信息最近修改时间
     */
    public void setBookModifiedTime(Date bookModifiedTime) {
        this.bookModifiedTime = bookModifiedTime;
    }
}
package com.hxb.oldBook.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.*;

@Table(name = "book_variety")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookVariety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 书籍种类名称
     */
    @Column(name = "book_type_name")
    private String bookTypeName;

    /**
     * 书籍种类介绍
     */
    @Column(name = "book_type_introduce")
    private String bookTypeIntroduce;

    /**
     * 书籍种类创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "book_type_create_time")
    private Date bookTypeCreateTime;

    /**
     * 书籍种类最近修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "book_type_modified_time")
    private Date bookTypeModifiedTime;

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
     * 获取书籍种类名称
     *
     * @return book_type_name - 书籍种类名称
     */
    public String getBookTypeName() {
        return bookTypeName;
    }

    /**
     * 设置书籍种类名称
     *
     * @param bookTypeName 书籍种类名称
     */
    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName == null ? null : bookTypeName.trim();
    }

    /**
     * 获取书籍种类介绍
     *
     * @return book_type_introduce - 书籍种类介绍
     */
    public String getBookTypeIntroduce() {
        return bookTypeIntroduce;
    }

    /**
     * 设置书籍种类介绍
     *
     * @param bookTypeIntroduce 书籍种类介绍
     */
    public void setBookTypeIntroduce(String bookTypeIntroduce) {
        this.bookTypeIntroduce = bookTypeIntroduce == null ? null : bookTypeIntroduce.trim();
    }

    /**
     * 获取书籍种类创建时间
     *
     * @return book_type_create_time - 书籍种类创建时间
     */
    public Date getBookTypeCreateTime() {
        return bookTypeCreateTime;
    }

    /**
     * 设置书籍种类创建时间
     *
     * @param bookTypeCreateTime 书籍种类创建时间
     */
    public void setBookTypeCreateTime(Date bookTypeCreateTime) {
        this.bookTypeCreateTime = bookTypeCreateTime;
    }

    /**
     * 获取书籍种类最近修改时间
     *
     * @return book_type_modified_time - 书籍种类最近修改时间
     */
    public Date getBookTypeModifiedTime() {
        return bookTypeModifiedTime;
    }

    /**
     * 设置书籍种类最近修改时间
     *
     * @param bookTypeModifiedTime 书籍种类最近修改时间
     */
    public void setBookTypeModifiedTime(Date bookTypeModifiedTime) {
        this.bookTypeModifiedTime = bookTypeModifiedTime;
    }
}
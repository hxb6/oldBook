package com.hxb.oldbook.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "book_variety")
public class BookVariety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 书籍种类名称
     */
    @Column(name = "book_name")
    private String bookName;

    /**
     * 书籍种类创建时间
     */
    @Column(name = "book_type_create_time")
    private Date bookTypeCreateTime;

    /**
     * 书籍种类最近修改时间
     */
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
     * @return book_name - 书籍种类名称
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 设置书籍种类名称
     *
     * @param bookName 书籍种类名称
     */
    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
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
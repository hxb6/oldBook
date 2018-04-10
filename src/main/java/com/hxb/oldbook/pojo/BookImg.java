package com.hxb.oldbook.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "book_img")
public class BookImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 图片保存路径
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 图片所属书籍的id
     */
    @Column(name = "book_id")
    private Integer bookId;

    /**
     * 书籍图片上传时间
     */
    @Column(name = "img_upload_time")
    private Date imgUploadTime;

    /**
     * 书籍图片最近修改时间
     */
    @Column(name = "img_modified_time")
    private Date imgModifiedTime;

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
     * 获取图片保存路径
     *
     * @return img_url - 图片保存路径
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片保存路径
     *
     * @param imgUrl 图片保存路径
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取图片所属书籍的id
     *
     * @return book_id - 图片所属书籍的id
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * 设置图片所属书籍的id
     *
     * @param bookId 图片所属书籍的id
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * 获取书籍图片上传时间
     *
     * @return img_upload_time - 书籍图片上传时间
     */
    public Date getImgUploadTime() {
        return imgUploadTime;
    }

    /**
     * 设置书籍图片上传时间
     *
     * @param imgUploadTime 书籍图片上传时间
     */
    public void setImgUploadTime(Date imgUploadTime) {
        this.imgUploadTime = imgUploadTime;
    }

    /**
     * 获取书籍图片最近修改时间
     *
     * @return img_modified_time - 书籍图片最近修改时间
     */
    public Date getImgModifiedTime() {
        return imgModifiedTime;
    }

    /**
     * 设置书籍图片最近修改时间
     *
     * @param imgModifiedTime 书籍图片最近修改时间
     */
    public void setImgModifiedTime(Date imgModifiedTime) {
        this.imgModifiedTime = imgModifiedTime;
    }
}
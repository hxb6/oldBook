package com.hxb.oldBook.service.impl;

import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.exception.CustomException;
import com.hxb.oldBook.mapper.BookInfoMapper;
import com.hxb.oldBook.pojo.BookInfo;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.BookInfoService;
import com.hxb.oldBook.utils.FileUtil;
import com.hxb.oldBook.utils.RequestUtil;
import com.hxb.oldBook.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Package: com.hxb.oldBook.service.impl
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 14:56
 * @Description:
 **/
@Service
public class BookInfoServiceImpl extends BaseServiceImpl<BookInfo> implements BookInfoService {

    @Autowired
    private BookInfoMapper bookInfoMapper;


    /**
     * 文件上传路径
     */
    @Value("${upload-path}")
    private String uploadPath;

    /**
     * 根据bootstrap table参数得到书籍列表
     * 管理员可全部查询，普通用户只能查看自己的书籍
     *
     * @param tableParams
     * @return
     */
    @Override
    public List<BookInfo> getBooksByTableParams(TableParams tableParams) {
        //从session中得到登录用户
        User user = UserUtil.getUserFormSession();
        return bookInfoMapper.getBooksByTableParams(tableParams, user);
    }

    /**
     * 设置书籍状态
     *
     * @param id         书籍id
     * @param bookStatus 书籍状态
     */
    @Override
    public void setBookStatus(Integer id, Integer bookStatus) {
        bookInfoMapper.setBookOut(id, bookStatus);
    }

    /**
     * 添加新的书籍
     *
     * @param imgFile  书籍图片
     * @param bookInfo Controller层封装的bookinfo对象
     */
    @Override
    public void addNewBook(MultipartFile imgFile, BookInfo bookInfo) throws IOException {
        String imgName = imgFile.getOriginalFilename();
        //利用系统时间 + 图片文件名称使图像文件名唯一 保存进数据库
        String imgUrl = new StringBuilder().append(String.valueOf(System.currentTimeMillis())).append(imgName).toString();
        //床架对象
        File file = new File(uploadPath, imgUrl);
        //上传图片
        FileUtil.multipartFileUpload(imgFile, file);
        //保存图片路径
        bookInfo.setImgUrl(imgUrl);
        //设置书籍添加时间和最近更新时间 这里两个时间相同
        Date date = new Date();
        bookInfo.setBookCreateTime(date);
        bookInfo.setBookModifiedTime(date);
        //默认书籍未上架
        bookInfo.setBookStatus((short) 0);
        User user = ((User) RequestUtil.getSession().getAttribute("user"));
        //绑定售卖书籍的用户
        bookInfo.setUserId(user.getId());
        bookInfoMapper.insertSelective(bookInfo);
    }


    /**
     * 根据传递参数得到数据总和
     *
     * @param tableParams
     * @return
     */
    @Override
    public int getCountByTableParams(TableParams tableParams) {
        //从session中得到登录用户
        User user = UserUtil.getUserFormSession();
        return bookInfoMapper.getCountByUserId(tableParams, user);
    }


    /**
     * 首页获取售卖的书籍 已上架的书籍并且该书籍所属的用户账号未被冻结
     *
     * @return
     */
    @Override
    public List<BookInfo> getSellBook() {
        List<BookInfo> lists = null;
        lists = bookInfoMapper.getSellBook();
        if (lists != null && lists.size() > 0) {
            return lists;
        } else {
            throw new CustomException(ResultEnum.NULL_SELL_BOOK);
        }
    }

    /**
     * 根据书籍类查询售卖的书籍
     *
     * @return
     */
    @Override
    public List<BookInfo> getSellBookByBookVariety(Integer bookVarietyId) {
        List<BookInfo> lists = null;
        lists = bookInfoMapper.getSellBookByBookVariety(bookVarietyId);
        if (lists != null && lists.size() > 0) {
            return lists;
        } else {
            throw new CustomException(ResultEnum.NULL_SELL_BOOK);
        }
    }

    /**
     * 根据书籍名称模糊查询售卖的书籍
     *
     * @return
     */
    @Override
    public List<BookInfo> getSellBookLikeBookName(String bookName) {
        List<BookInfo> lists = null;
        lists = bookInfoMapper.getSellBookLikeBookName(bookName);
        if (lists != null && lists.size() > 0) {
            return lists;
        } else {
            throw new CustomException(ResultEnum.NULL_SELL_BOOK);
        }
    }
}

package com.hxb.oldBook.service;

import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.BookInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Package: com.hxb.oldBook.service
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 14:55
 * @Description: 书籍信息接口
 **/
public interface BookInfoService extends BaseService<BookInfo> {

    /**
     * 根据bootstrap table参数得到书籍列表
     * @param tableParams
     * @return
     */
    List<BookInfo> getBooksByTableParams(TableParams tableParams);

    /**
     * 设置书籍状态
     * @param id 书籍id
     * @param bookStatus 书籍状态
     */
    void setBookStatus(Integer id,Integer bookStatus);

    /**
     * 添加新的书籍
     * @param imgFile 书籍图片
     * @param bookInfo Controller层封装的bookinfo对象
     */
    void addNewBook(MultipartFile imgFile,BookInfo bookInfo) throws IOException;



    /**
     * 根据传递参数得到数据总和
     * @param tableParams
     * @return
     */
    int getCountByTableParams(TableParams tableParams);


    /**
     * 首页获取售卖的书籍 已上架的书籍并且该书籍所属的用户账号未被冻结
     * @return
     */
    List<BookInfo> getSellBook();

    /**
     * 根据书籍类查询售卖的书籍
     * @return
     */
    List<BookInfo> getSellBookByBookVariety(Integer bookVarietyId);

    /**
     * 根据书籍名称模糊查询售卖的书籍
     * @return
     */
    List<BookInfo> getSellBookLikeBookName(String bookName);
}

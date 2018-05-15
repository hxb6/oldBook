package com.hxb.oldBook.service.impl;

import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.mapper.BookInfoMapper;
import com.hxb.oldBook.pojo.BookInfo;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.BookInfoService;
import com.hxb.oldBook.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 根据bootstrap table参数得到书籍列表
     * 管理员可全部查询，普通用户只能查看自己的书籍
     * @param tableParams
     * @return
     */
    @Override
    public List<BookInfo> getBooksByTableParams(TableParams tableParams) {
        //从session中得到登录用户
        User user = (User) RequestUtil.getSession().getAttribute("user");
        Short roleType = user.getRoleType();
        Integer userId = user.getId();
        return bookInfoMapper.getBooksByTableParams(tableParams,roleType,userId);
    }

    /**
     * 设置书籍状态
     * @param id 书籍id
     * @param bookStatus 书籍状态
     */
    @Override
    public void setBookStatus(Integer id,Integer bookStatus) {
        bookInfoMapper.setBookOut(id,bookStatus);
    }
}

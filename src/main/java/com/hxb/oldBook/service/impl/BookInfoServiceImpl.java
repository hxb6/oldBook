package com.hxb.oldBook.service.impl;

import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.mapper.BookInfoMapper;
import com.hxb.oldBook.pojo.BookInfo;
import com.hxb.oldBook.service.BookInfoService;
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
     * @param tableParams
     * @return
     */
    @Override
    public List<BookInfo> getBooksByTableParams(TableParams tableParams) {
        return bookInfoMapper.getBooksByTableParams(tableParams);
    }
}

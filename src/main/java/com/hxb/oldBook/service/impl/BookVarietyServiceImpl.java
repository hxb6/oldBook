package com.hxb.oldBook.service.impl;

import com.hxb.oldBook.mapper.BookVarietyMapper;
import com.hxb.oldBook.pojo.BookVariety;
import com.hxb.oldBook.service.BookVarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: com.hxb.oldBook.service.impl
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 14:54
 * @Description:
 **/
@Service
public class BookVarietyServiceImpl extends BaseServiceImpl<BookVariety> implements BookVarietyService {

    @Autowired
    private BookVarietyMapper bookVarietyMapper;

    /**
     * 查询所有对象
     *
     * @return 对象结合
     */
    @Override
    public List<BookVariety> selectAll() {
        return bookVarietyMapper.selectAll();
    }
}

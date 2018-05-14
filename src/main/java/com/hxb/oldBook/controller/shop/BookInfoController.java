package com.hxb.oldBook.controller.shop;

import com.hxb.oldBook.common.TablePageResult;
import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.BookInfo;
import com.hxb.oldBook.service.BookInfoService;
import com.hxb.oldBook.utils.TablePageResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Package: com.hxb.oldBook.controller.shop
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/14 18:58
 * @Description: 书籍信息控制器类
 **/
@Controller
@RequestMapping("/book")
public class BookInfoController {

    /**
     * 注入BookInfoService对象
     */
    @Autowired
    private BookInfoService bookInfoService;


    /**
     * 添加书籍记录 先保存
     * @param bookImg
     * @return
     */
    @PostMapping("/addNewBook")
    public String addNewBook(MultipartFile bookImg){
        return null;
    }

    /**
     * 根据bootstrap table参数得到书籍列表
     * @param tableParams
     * @return
     */
    @GetMapping("/getBooksByTableParams")
    @ResponseBody
    public TablePageResult getBooksByTableParams(TableParams tableParams){
        List<BookInfo> lists = bookInfoService.getBooksByTableParams(tableParams);
        Integer total = bookInfoService.getCount(new BookInfo());
        return TablePageResultUtil.success(total, lists);
    }
}

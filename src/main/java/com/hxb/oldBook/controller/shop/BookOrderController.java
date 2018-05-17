package com.hxb.oldBook.controller.shop;

import com.hxb.oldBook.pojo.BookInfo;
import com.hxb.oldBook.service.BookInfoService;
import com.hxb.oldBook.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Package: com.hxb.oldBook.controller.shop
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/17 21:35
 * @Description: 书籍订单控制类
 **/
@Controller
@RequestMapping("/book")
public class BookOrderController {

    @Autowired
    private BookOrderService bookOrderService;

    @Autowired
    private BookInfoService bookInfoService;

    @RequestMapping("/toOrderSure")
    public String toOrderSure(@RequestParam Integer bookId,
                              @RequestParam Integer bookNum,
                              Model model){
        BookInfo bookInfo = bookInfoService.selectByPrimaryKey(bookId);
        bookInfo.setImgUrl("/" + bookInfo.getImgUrl());
        Double bookPrice = bookInfo.getBookPrice().doubleValue();
        Double allPrice = bookPrice * bookNum;
        model.addAttribute("bookInfo", bookInfo);
        model.addAttribute("bookNum", bookNum);
        model.addAttribute("allPrice", allPrice);
        return "orderSure";
    }
}

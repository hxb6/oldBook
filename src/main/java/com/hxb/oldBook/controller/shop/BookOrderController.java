package com.hxb.oldBook.controller.shop;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.common.TablePageResult;
import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.BookInfo;
import com.hxb.oldBook.pojo.BookOrder;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.BookInfoService;
import com.hxb.oldBook.service.BookOrderService;
import com.hxb.oldBook.utils.ResultUtil;
import com.hxb.oldBook.utils.TablePageResultUtil;
import com.hxb.oldBook.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

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

    /**
     * 创建订单
     * @param bookId
     * @param bookNum
     * @return
     */
    @RequestMapping("/createOrder")
    @ResponseBody
    public Result createOrder(Integer bookId, Integer bookNum){
        bookOrderService.createOrder(bookId, bookNum);
        return ResultUtil.success(ResultEnum.SUCCESS);
    }

    /**
     * 获取自己的订单
     * @param tableParams
     * @return
     */
    @GetMapping("/getOrder")
    @ResponseBody
    public TablePageResult getOrder(TableParams tableParams){
        User user = UserUtil.getUserFormSession();
        List<BookOrder> lists = bookOrderService.queryOrder(tableParams, user);
        Integer total = bookOrderService.getOrderCount(tableParams, user);
        return TablePageResultUtil.success(total, lists);
    }


    /**
     * 管理员获取所有的订单
     * @param tableParams
     * @return
     */
    @GetMapping("/getAll")
    @ResponseBody
    public TablePageResult getAll(TableParams tableParams){
        List<BookOrder> lists = bookOrderService.getAll(tableParams);
        Integer total = bookOrderService.getCount(new BookOrder());
        return TablePageResultUtil.success(total, lists);
    }
}

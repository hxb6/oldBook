package com.hxb.oldBook.controller.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: com.hxb.oldBook.controller.shop
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/4 16:52
 * @Description: 个人商铺信息管理
 **/
@Controller
@RequestMapping("/shop")
public class MyShopInfoController {
    @RequestMapping("/info")
    public String toShop(){
        return "myShop";
    }

    @RequestMapping("/bookAdd")
    public String toBookAdd(){
        return "bookAdd";
    }

    @RequestMapping("/toSellOrder")
    public String toSellOrder(){
        return "sellOrder";
    }
}

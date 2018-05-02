package com.hxb.oldBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Package: com.hxb.oldBook.controller
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/2 15:33
 * @Description: 系统前台首页
 **/
@Controller
public class HomePageController {

    @GetMapping("/index")
    public String toIndex(){
        //页面数据加载
        return "index";
    }
}

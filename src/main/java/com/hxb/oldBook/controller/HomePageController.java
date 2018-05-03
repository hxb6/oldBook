package com.hxb.oldBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Package: com.hxb.oldBook.controller
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/2 15:33
 * @Description: 系统前台首页
 **/
@Controller
public class HomePageController {

    @RequestMapping("/index")
    public String toIndex(Model model, HttpSession session){
        //页面数据加载
        return "index";
    }
}

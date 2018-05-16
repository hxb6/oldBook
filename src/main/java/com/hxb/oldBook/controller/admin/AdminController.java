package com.hxb.oldBook.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: com.hxb.oldBook.controller.admin
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/6 13:49
 * @Description: 后台页面的跳转 自身信息维护
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * 进入后台管理页面
     * @return
     */
    @RequestMapping("/toAdmin")
    public String toAdmin(){
        return "admin/admin";
    }

    @RequestMapping("/toBookList")
    public String toBookList(){
        return "admin/bookList";
    }


    /**
     * 进入申请处理页面
     * @return
     */
    @RequestMapping("/toDealApply")
    public String toDearApply(){
        return "admin/dealApply";
    }

    /**
     * 进入用户列表页面
     * @return
     */
    @RequestMapping("/toUserList")
    public String toUserList(){
        return "admin/userList";
    }
}

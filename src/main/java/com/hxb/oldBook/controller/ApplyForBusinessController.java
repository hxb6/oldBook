package com.hxb.oldBook.controller;

import com.hxb.oldBook.service.ApplyForBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: com.hxb.oldBook.controller
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/4 16:32
 * @Description: 申请成为商家控制类
 **/
@Controller
@RequestMapping("/user")
public class ApplyForBusinessController {

    @Autowired
    private ApplyForBusinessService applyForBusinessService;


    @RequestMapping("/apply")
    public String toApply(){
        return "apply";
    }

}

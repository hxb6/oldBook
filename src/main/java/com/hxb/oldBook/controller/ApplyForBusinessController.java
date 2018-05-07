package com.hxb.oldBook.controller;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.pojo.ApplyForBusiness;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.ApplyForBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
    public String toApply() {
        return "apply";
    }

    /**
     * 申请成为商家
     *
     * @param applyForBusiness 申请信息
     * @return 统一结果集
     */
    @PostMapping("/applyToBeBusiness")
    @ResponseBody
    public Result applyToBeBusiness(@RequestBody ApplyForBusiness applyForBusiness) {
        return applyForBusinessService.applyToBeBusiness(applyForBusiness);
    }


    /**
     * 根据用户id查询 审批记录
     * @param session 会话session
     * @return
     */
    @GetMapping("/queryByUserId")
    @ResponseBody
    public Result queryByUserId(HttpSession session){
        //获取申请用户的id
        Integer userId = ((User) session.getAttribute("user")).getId();
        //根据id查询审批记录
        return applyForBusinessService.queryByUserId(userId);
    }


}

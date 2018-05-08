package com.hxb.oldBook.controller;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.pojo.ApplyForBusiness;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.ApplyForBusinessService;
import com.hxb.oldBook.utils.ResultUtil;
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

    /**
     * 设置该条不合格信息状态不可用
     * @param applyForBusiness
     * @return
     */
    @PostMapping("/updateNotActive")
    @ResponseBody
    public Result updateNotActiveByUserId(@RequestBody ApplyForBusiness applyForBusiness){
        applyForBusinessService.updateNotActive(applyForBusiness);
        return ResultUtil.success(ResultEnum.SUCCESS);
    }


}

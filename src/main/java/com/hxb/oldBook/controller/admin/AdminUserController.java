package com.hxb.oldBook.controller.admin;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.UserService;
import com.hxb.oldBook.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.hxb.oldBook.controller.admin
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/8 15:48
 * @Description: 管理员操作用户信息
 **/
@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private UserService userService;

    /**
     * 根据id得到用户
     * @param userId
     * @return
     */
    @GetMapping("/getUserById")
    @ResponseBody
    public Result getUserById(@RequestParam("userId")Integer userId){
        User user = userService.selectByPrimaryKey(userId);
        return ResultUtil.success(ResultEnum.SUCCESS, user);
    }
}

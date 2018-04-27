package com.hxb.oldBook.controller;

import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.exception.CustomException;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.service.UserService;
import com.hxb.oldBook.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Package: com.hxb.oldBook.controller.user
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 15:01
 * @Description:用户信息控制类
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestParam(value = "userAccount")String userAccount,
                           @RequestParam(value = "password")String password) {

        User user = userService.selectUserByUserAccount(userAccount);
        return ResultUtil.success("用户已经注册", user);
    }

}

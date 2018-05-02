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

    /**
     * 模板跳转到注册页面
     * @return
     */
    @GetMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    /**
     * 模板跳转到登录页面
     * 清除登录标记
     * @return
     */
    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 模板跳转到忘记密码页面
     * @return
     */
    @GetMapping("/toPasswordForget")
    public String toPasswordForget(){
        return "passwordForget";
    }

    @GetMapping("/toPerson")
    public String toPerson(){
        return "person";
    }

    /**
     * 用户注册
     * @param userAccount
     * @param password
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestParam(value = "userAccount")String userAccount,
                           @RequestParam(value = "password")String password) {

        return userService.register(userAccount,password);
    }

    /**
     * 用户登录
     * @param userAccount
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam(value = "userAccount")String userAccount,
                           @RequestParam(value = "password")String password) {

        return userService.login(userAccount,password);
    }

}

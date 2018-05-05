package com.hxb.oldBook.controller;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Package: com.hxb.oldBook.controller.user
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 15:01
 * @Description:用户信息控制类
 **/
@Controller
public class NoNeedLoginController {

    @Autowired
    private UserService userService;

    /**
     * 模板跳转到注册页面
     *
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    /**
     * 模板跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 模板跳转到忘记密码页面
     *
     * @return
     */
    @RequestMapping("/toPasswordForget")
    public String toPasswordForget() {
        return "passwordForget";
    }

    /**
     * 根据用户账号判断跳转到本页面还是
     * 跳转到确认密保页面 并传递参数回来
     *
     * @return
     */
    @RequestMapping("/forgetPasswordNext")
    public String toForgetPasswordNext(@RequestParam("userAccount") String userAccount, Model model,HttpSession session) {
        //根据账号得到User对象
        User user = userService.selectUserByUserAccount(userAccount);
        /*user为null或者没有设置密保问题 返回本页面给出提示
            否则进入密保页面 将密保问题传回去并且保存当前用户id到session 以备后面修改重置密码使用
         */
        if (user == null) {
            model.addAttribute("errorInfo", "账号不存在");
            return "passwordForget";
        } else if(user.getEncryptedProblem() == null){
            model.addAttribute("errorInfo", "您暂未设置密保问题,请联系管理员");
            return "passwordForget";
        } else {
            // 保存用户id到session中 后面重置方法时要使用
            session.setAttribute("userId", user.getId());
            model.addAttribute("encryptedProblem", user.getEncryptedProblem());
            return "forgetPasswordNext";
        }
    }

    /**
     * 重置密码
     * @param encryptedQuestion
     * @return Result结果集
     */
    @PostMapping("/resetPassword")
    @ResponseBody
    public Result resetPassword(@RequestParam("encryptedQuestion") String encryptedQuestion,HttpSession session){
        //重置密码成功 清除忘记密码这个步骤保存的用户id
        session.removeAttribute("userId");
        return userService.resetPassword(encryptedQuestion);
    }


    /**
     * 用户注册
     *
     * @param userAccount
     * @param password
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestParam(value = "userAccount") String userAccount,
                           @RequestParam(value = "password") String password) {

        return userService.register(userAccount, password);
    }

    /**
     * 用户登录
     *
     * @param userAccount
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam(value = "userAccount") String userAccount,
                        @RequestParam(value = "password") String password) {

        return userService.login(userAccount, password);
    }

}

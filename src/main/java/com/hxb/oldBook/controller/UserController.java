package com.hxb.oldBook.controller;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.UserService;
import com.hxb.oldBook.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Package: com.hxb.oldBook.controller
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/3 14:47
 * @Description: 用户行为控制
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 跳转到个人中心我是用户页面
     * @return
     */
    @RequestMapping("/person")
    public String toPerson(){
        return "person";
    }

    /**
     * 进入修改密码页面
     * @return
     */
    @RequestMapping("/changePassword")
    public String toChangePassword(){
        return "changePassword";
    }

    /**
     * 用户退出登录 清除登录状态
     * @param session
     * @return
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        //清除session
        session.invalidate();
        return "login";
    }

    /**
     * 根据用户id得到用户
     * @param session
     * @return
     */
    @GetMapping("/getUserById")
    @ResponseBody
    public Result getUserById(HttpSession session){
        Integer userId = ((User) session.getAttribute("user")).getId();
        User user = userService.selectByPrimaryKey(userId);
        return ResultUtil.success(ResultEnum.SUCCESS, user);
    }

    /**
     * 根据主键更新属性不为null的值
     * @param user 用户
     * @return
     */
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user,HttpSession session){
        //设置最近修改信息的时间
        user.setUserModifiedTime(new Date());
        userService.updateByPrimaryKeySelective(user);
        //设置最新用户信息到session中
        session.setAttribute("user", userService.selectByPrimaryKey(user.getId()));
        return "person";
    }


    /**
     *  修改密码
     * @param session 会话session
     * @param oldPassword  旧密码
     * @param newPassword  新密码
     * @return
     */
    @PostMapping("/changePassword")
    @ResponseBody
    public Result changePassword(
            HttpSession session,
            @RequestParam("oldPassword")String oldPassword,
            @RequestParam("newPassword")String newPassword){
        Integer userId = ((User) session.getAttribute("user")).getId();
        if (oldPassword != null && newPassword != null && userId != null) {
            return userService.changePassword(userId, oldPassword, newPassword);
        }else{
            return ResultUtil.error("密码不能为空", null);
        }
    }
}

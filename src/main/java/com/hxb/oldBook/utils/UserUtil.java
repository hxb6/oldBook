package com.hxb.oldBook.utils;

import com.hxb.oldBook.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * @Package: com.hxb.oldBook.utils
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/8 17:50
 * @Description: 从会话session中得到登录的User对象 和更新新的User对象到session中
 **/
public class UserUtil {


    /**
     * 从session中得到登录的用户
     * @return
     */
    public static User getUserFormSession(){
        HttpSession session = RequestUtil.getSession();
        return ((User) session.getAttribute("user"));
    }

    /**
     * 得到session中登录用户的id
     * @return
     */
    public static Integer getUserId(){
        return getUserFormSession().getId();
    }

    /**
     * 保存新的user对象到session中
     * @param user
     */
    public static void setNewUserIntoSession(User user){
        HttpSession session = RequestUtil.getSession();
        session.setAttribute("user", user);
        session.setAttribute("isLogin", "yes");
    }
}

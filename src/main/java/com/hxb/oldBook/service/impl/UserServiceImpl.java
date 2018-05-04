package com.hxb.oldBook.service.impl;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.exception.CustomException;
import com.hxb.oldBook.mapper.UserMapper;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.UserService;
import com.hxb.oldBook.utils.MD5Util;
import com.hxb.oldBook.utils.RequestUtil;
import com.hxb.oldBook.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Package: com.hxb.oldBook.service.impl
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 14:48
 * @Description:
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {


    /**
     * 注入用户mapper接口对象
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过用户账号得到用户对象
     *
     * @param userAccount 用户账号
     * @return 查询结果封装成result
     */
    @Override
    public User selectUserByUserAccount(String userAccount) {
        return userMapper.selectUserByUserAccount(userAccount);
    }

    /**
     * 用户注册
     *
     * @param userAccount 用户账号
     * @param password    用户密码
     * @return 封装成结果集
     */
    @Override
    public Result register(String userAccount, String password) {
        /*
        判断用户是否已经注册
         */
        if (selectUserByUserAccount(userAccount) != null) {
            throw new CustomException(ResultEnum.ALREADY_REGISTER);
        }
        //创建用户
        User user = new User();
        //默认昵称,不是登录用户名
        user.setUserName("xx同学");
        //设置账号
        user.setUserAccount(userAccount);
        //得到盐
        String salt = MD5Util.getSalt();
        //设置盐
        user.setSalt(salt);
        //组合明文密码和盐
        password += salt;
        //设置MD5加密后的密码
        user.setPassword(MD5Util.getPassword(password));
        //默认不是商家
        user.setIsMerchant(false);
        //普通用户
        user.setRoleType(((short) 1));
        Date date = new Date();
        //注册成为用户的时间和最后一次修改的时间
        user.setUserRegisterTime(date);
        user.setUserModifiedTime(date);
        //默认账号可用
        user.setIsValid(true);
        //保存到数据库
        userMapper.insert(user);
        return ResultUtil.success(ResultEnum.REGISTER_SUCCESS);
    }

    /**
     * 用户登录
     *
     * @param userAccount 用户账号
     * @param password    用户密码
     * @return 封装成结果集
     */
    @Override
    public Result login(String userAccount, String password) {
        User user = selectUserByUserAccount(userAccount);
        if (user == null) {
            throw new CustomException(ResultEnum.ACCOUNT_PASSWORD_ERROR);
        } else {
            /**
             * 检查该账号是否可用
             */
            if (!user.getIsValid()) {
                throw new CustomException(ResultEnum.ACCOUNT_NOT_VALID);
            }
            /*
            根据登录密码和用户的盐得到加密后的MD5密码,和数据库中的MD5密码对比
             */
            String md5Password = MD5Util.getPassword(password + user.getSalt());
            if (!md5Password.equals(user.getPassword())) {
                throw new CustomException(ResultEnum.ACCOUNT_PASSWORD_ERROR);
            }
            //得到会话session
            HttpSession session = RequestUtil.getSession();
            //保存用户登录标记和信息到session中
            session.setAttribute("user", user);
            session.setAttribute("isLogin", "yes");
            return ResultUtil.success("登录成功", user);
        }
    }

    /**
     * 修改密码
     *
     * @param id          用户id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 封装成结果集
     */
    @Override
    public Result changePassword(Integer id, String oldPassword, String newPassword) {
        //根据主键得到用户
        User user = userMapper.selectByPrimaryKey(id);
        //用户的盐
        String salt = user.getSalt();
        /*
        用户输入的旧密码和盐得到MD5密码和原MD5密码对比
         */
        String oldMD5Password = MD5Util.getPassword(oldPassword + salt);
        if (oldMD5Password != null && oldMD5Password.equals(user.getPassword())) {
            //设置新密码加盐的MD5密码
            user.setPassword(MD5Util.getPassword(newPassword + salt));
            userMapper.updateByPrimaryKeySelective(user);
            return ResultUtil.success(ResultEnum.SUCCESS);
        } else {
            throw new CustomException(ResultEnum.OLD_PASSWORD_ERROR);
        }

    }
}

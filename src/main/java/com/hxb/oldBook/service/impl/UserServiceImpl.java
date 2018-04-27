package com.hxb.oldBook.service.impl;

import com.hxb.oldBook.mapper.UserMapper;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
     * @param userAccount 用户账号
     * @return 用户对象
     */
    @Override
    public User selectUserByUserAccount(String userAccount) {
        return userMapper.selectUserByUserAccount(userAccount);
    }



}

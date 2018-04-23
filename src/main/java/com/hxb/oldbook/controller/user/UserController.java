package com.hxb.oldbook.controller.user;

import com.hxb.oldbook.mapper.UserMapper;
import com.hxb.oldbook.pojo.User;
import com.hxb.oldbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Package: com.hxb.oldbook.controller.user
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 15:01
 * @Description:
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public User getUser(){
        System.out.println("hello");
        return userService.selectByPrimaryKey(1);
    }

    @PostMapping("/save")
    public void add(){
        User user = new User();
        user.setUserName("何晓波");
        user.setPassword("saf");
        user.setIsMerchant(true);
        user.setRegisterMerchantTime(new Date());
        user.setUserAccount("safsa5");
        userService.insert(user);
    }

    @PostMapping("/delete")
    public void deleteByPrimaryKey(){
        userService.deleteByPrimaryKey(2);
    }

    @GetMapping("/test")
    public List<User> get(){
        return userService.selectAll();
    }

}

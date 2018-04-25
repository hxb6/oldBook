package com.hxb.oldBook.controller;

import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.exception.CustomException;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.service.UserService;
import com.hxb.oldBook.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package: com.hxb.oldBook.controller.user
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 15:01
 * @Description:用户控制类
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test/{id}")
    public Result test(@PathVariable(value = "id") String id) {
        try {
            User user = userService.selectByPrimaryKey(Integer.parseInt(id));
            if (user != null) {
                return ResultUtil.success(ResultEnum.SUCCESS, user);
            } else {
                return ResultUtil.success(ResultEnum.SUCCESS_NULL);
            }
        } catch (Exception e) {
            throw new CustomException(ResultEnum.ERROR);
        }
    }

}

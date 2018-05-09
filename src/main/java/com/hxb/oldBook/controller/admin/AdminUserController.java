package com.hxb.oldBook.controller.admin;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.common.TablePageResult;
import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.UserService;
import com.hxb.oldBook.utils.ResultUtil;
import com.hxb.oldBook.utils.TablePageResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     *
     * @param userId
     * @return
     */
    @GetMapping("/getUserById")
    @ResponseBody
    public Result getUserById(@RequestParam("userId") Integer userId) {
        User user = userService.selectByPrimaryKey(userId);
        return ResultUtil.success(ResultEnum.SUCCESS, user);
    }

    /**
     * 根据TableParams得到对应用户数据
     *
     * @param tableParams
     * @return
     */
    @GetMapping("/getUserByTableParams")
    @ResponseBody
    public TablePageResult getUserByTableParams(TableParams tableParams) {
        List<User> lists = userService.getUserByTableParams(tableParams);
        Integer total = userService.getCount(new User());
        if (lists != null && lists.size() > 0) {
            //total要减去1 去除管理员
            return TablePageResultUtil.success(total-1, lists);
        } else {
            return null;
        }

    }

    /**
     * 管理员重置用户密码
     * @return
     */
    @PostMapping("/adminResetPassword")
    @ResponseBody
    public Result adminResetPassword(@RequestParam("id")Integer id){
        return userService.adminResetUserPassword(id);
    }

    /**
     * 管理员更新用户 冻结或解封用户
     * @param user
     * @return
     */
    @PostMapping("/adminUpdateUser")
    @ResponseBody
    public Result adminUpdateUser(@RequestBody User user){
        userService.updateByPrimaryKeySelective(user);
        return ResultUtil.success(ResultEnum.SUCCESS);
    }
}

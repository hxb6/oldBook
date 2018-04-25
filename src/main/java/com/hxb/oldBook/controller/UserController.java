package com.hxb.oldBook.controller;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.resultbean.ResultBean;
import com.hxb.oldBook.service.UserService;
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
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @GetMapping("/test/{id}")
    public ResultBean test(@PathVariable(value = "id")String id){
        User user = userService.selectByPrimaryKey(Integer.parseInt(id));
        if (user != null) {
            return this.ajaxSuccessMessage("得到学生", user);
        } else {
            return this.ajaxErrorMessage("没有该学生", user);
        }
    }

}

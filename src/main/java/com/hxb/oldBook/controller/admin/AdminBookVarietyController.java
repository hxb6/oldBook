package com.hxb.oldBook.controller.admin;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.pojo.BookVariety;
import com.hxb.oldBook.service.BookVarietyService;
import com.hxb.oldBook.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Package: com.hxb.oldBook.controller.admin
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/9 23:28
 * @Description: 管理员 更新书籍分类信息
 **/
@Controller
@RequestMapping("/admin")
public class AdminBookVarietyController {

    @Autowired
    private BookVarietyService bookVarietyService;

    /**
     * 管理员修改书籍分类信息
     * @param bookVariety
     * @return
     */
    @PostMapping("/updateBookVariety")
    @ResponseBody
    public Result updateBookVariety(@RequestBody BookVariety bookVariety){
        //书籍最近更新时间
        bookVariety.setBookTypeModifiedTime(new Date());
        bookVarietyService.updateByPrimaryKeySelective(bookVariety);
        return ResultUtil.success(ResultEnum.SUCCESS);
    }

    /**
     * 管理员添加书籍分类信息
     * @param bookVariety
     * @return
     */
    @PostMapping("/addBookVariety")
    @ResponseBody
    public Result addBookVariety(@RequestBody BookVariety bookVariety){
        Date date = new Date();
        //书籍分类添加时间
        bookVariety.setBookTypeCreateTime(date);
        //书籍分类最近更新时间
        bookVariety.setBookTypeModifiedTime(new Date());
        bookVarietyService.insert(bookVariety);
        return ResultUtil.success(ResultEnum.SUCCESS);
    }

}

package com.hxb.oldBook.controller.shop;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.common.TablePageResult;
import com.hxb.oldBook.pojo.BookVariety;
import com.hxb.oldBook.service.BookVarietyService;
import com.hxb.oldBook.utils.ResultUtil;
import com.hxb.oldBook.utils.TablePageResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Package: com.hxb.oldBook.controller.shop
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/9 22:49
 * @Description: 书籍种类控制器 书籍种类查询 用户只有这个功能
 **/
@Controller
@RequestMapping("/user")
public class BookVarietyController {

    @Autowired
    private BookVarietyService bookVarietyService;

    /**
     * 查询书籍分类信息
     * @return
     */
    @GetMapping("/getAllBookVariety")
    @ResponseBody
    public TablePageResult getAllBookVariety(){
        List<BookVariety> lists = bookVarietyService.selectAll();
        Integer total = lists.size();
        return TablePageResultUtil.success(total, lists);
    }

    /**
     * 根据书籍分类id得到书籍分类信息
     * @return
     */
    @GetMapping("/getBookTypeById")
    @ResponseBody
    public Result getBookTypeById(@RequestParam("id")Integer id){
        BookVariety bookVariety = bookVarietyService.selectByPrimaryKey(id);
        return ResultUtil.success(ResultEnum.SUCCESS, bookVariety);
    }
}

package com.hxb.oldBook.controller.shop;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.common.TablePageResult;
import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.BookInfo;
import com.hxb.oldBook.service.BookInfoService;
import com.hxb.oldBook.utils.ResultUtil;
import com.hxb.oldBook.utils.TablePageResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Package: com.hxb.oldBook.controller.shop
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/14 18:58
 * @Description: 书籍信息控制器类
 **/
@Controller
@RequestMapping("/book")
public class BookInfoController {

    /**
     * 注入BookInfoService对象
     */
    @Autowired
    private BookInfoService bookInfoService;



    /**
     * 添加书籍记录 包括书籍图片和信息
     *
     * @param bookImg 图片文件
     * @return
     */
    @PostMapping("/addNewBook")
    public String addNewBook(MultipartFile bookImg,
                             String bookName,
                             Short bookSave,
                             String bookIntroduction,
                             BigDecimal bookPrice,
                             Integer bookVarietyId) throws IOException {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName(bookName);
        bookInfo.setBookSave(bookSave);
        bookInfo.setBookPrice(bookPrice);
        bookInfo.setBookIntroduction(bookIntroduction);
        bookInfo.setBookVarietyId(bookVarietyId);
        bookInfoService.addNewBook(bookImg, bookInfo);
        return "bookAdd";
    }

    /**
     * 根据bootstrap table参数得到书籍列表
     *
     * @param tableParams
     * @return
     */
    @GetMapping("/getBooksByTableParams")
    @ResponseBody
    public TablePageResult getBooksByTableParams(TableParams tableParams) {
        List<BookInfo> lists = bookInfoService.getBooksByTableParams(tableParams);
        Integer total = bookInfoService.getCountByTableParams(tableParams);
        return TablePageResultUtil.success(total, lists);
    }

    /**
     * 改变书籍状态
     *
     * @param bookStatus
     * @return
     */
    @PostMapping("/setBookStatus")
    @ResponseBody
    public Result setBookStatus(@RequestParam("id") Integer id, @RequestParam("bookStatus") Integer bookStatus) {
        bookInfoService.setBookStatus(id, bookStatus);
        return ResultUtil.success(ResultEnum.SUCCESS);
    }

    /**
     * 根据书籍id返回书籍信息
     * @param id
     * @return
     */
    @GetMapping("/getBookById")
    @ResponseBody
    public Result getBookById(@RequestParam("id") Integer id){
        BookInfo bookInfo = bookInfoService.selectByPrimaryKey(id);
        return ResultUtil.success(ResultEnum.SUCCESS, bookInfo);
    }


    /**
     * 更新书籍信息(不包括修改书籍图片信息)
     * @param bookInfo
     * @return
     */
    @PostMapping("/updateBook")
    @ResponseBody
    public Result updateBookInfo(@RequestBody BookInfo bookInfo){
        //设置书籍最近更新时间
        bookInfo.setBookModifiedTime(new Date());
        bookInfoService.updateByPrimaryKeySelective(bookInfo);
        return ResultUtil.success(ResultEnum.SUCCESS);
    }


    /**
     * 查询售卖的书籍
     * @return
     */
    @GetMapping("/getSellBook")
    @ResponseBody
    public Result getSellBook(){
        List<BookInfo> lists = bookInfoService.getSellBook();
        return ResultUtil.success(ResultEnum.SUCCESS, lists);
    }

    /**
     * 根据书籍种类查询得到售卖书籍
     * @param bookVarietyId 书籍种类id
     * @return
     */
    @GetMapping("/getSellBookByBookVariety")
    @ResponseBody
    public Result getSellBookByBookVariety(@RequestParam("bookVarietyId") Integer bookVarietyId){
        List<BookInfo> lists = bookInfoService.getSellBookByBookVariety(bookVarietyId);
        return ResultUtil.success(ResultEnum.SUCCESS, lists);
    }

    /**
     * 根据书籍名称模糊查询得到售卖书籍
     * @param bookName 用户搜索框输入书籍名称
     * @return
     */
    @GetMapping("/getSellBookLikeBookName")
    @ResponseBody
    public Result getSellBookLikeBookName(@RequestParam("bookName") String bookName){
        List<BookInfo> lists = bookInfoService.getSellBookLikeBookName(bookName);
        return ResultUtil.success(ResultEnum.SUCCESS, lists);
    }


    /**
     * 根据书籍id得到书籍信息
     * 跳转到书籍详情页面
     * @param id
     * @return
     */
    @RequestMapping("/toBookDetails")
    public String toBookDetails(@RequestParam("id") Integer id, Model model){
        BookInfo bookInfo = bookInfoService.selectByPrimaryKey(id);
        bookInfo.setImgUrl("/" + bookInfo.getImgUrl());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormat = simpleDateFormat.format(bookInfo.getBookCreateTime());
        model.addAttribute("createDate", dateFormat);
        model.addAttribute("bookInfo", bookInfo);
        return "bookDetails";
    }




}

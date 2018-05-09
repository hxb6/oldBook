package com.hxb.oldBook.controller.admin;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.common.TablePageResult;
import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.ApplyForBusiness;
import com.hxb.oldBook.service.ApplyForBusinessService;
import com.hxb.oldBook.utils.ResultUtil;
import com.hxb.oldBook.utils.TablePageResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Package: com.hxb.oldBook.controller.admin
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/7 12:06
 * @Description: 管理员处理用户申请成为商家信息控制
 **/
@Controller
@RequestMapping("/admin")
public class AdminDealApplyController {

    /**
     * 自动注入ApplyForBusinessService对象
     */
    @Autowired
    private ApplyForBusinessService applyForBusinessService;

    /**
     * 管理员处理请求信息 更新记录
     *
     * @param applyForBusiness
     * @return
     */
    @PostMapping("/updateApplyForBusiness")
    @ResponseBody
    public Result updateApplyForBusiness(@RequestBody ApplyForBusiness applyForBusiness) {
        //得到影响数据库记录的条数
        int i = applyForBusinessService.updateByPrimaryKeySelective(applyForBusiness);
        if (i > 0) {
            return ResultUtil.success(ResultEnum.SUCCESS, applyForBusiness);
        } else {
            return ResultUtil.error(ResultEnum.FAILE);
        }
    }

    /**
     * 根据表格参数得到对应记录
     * 得到未审批的记录 status = 0
     * @param tableParams 表格参数对象
     * @return bootstrap table必须接受的对象封装 包含 rows和total两个参数
     */
    @GetMapping("/getAllApplyForBusiness")
    @ResponseBody
    public TablePageResult selectAllApplyForBusiness(TableParams tableParams) {
        List<ApplyForBusiness> lists = applyForBusinessService.queryByPage(tableParams);
        Integer total = applyForBusinessService.getCountByIsActive(1);
        if (lists != null && lists.size() > 0) {
            return TablePageResultUtil.success(total, lists);
        } else {
            return null;
        }
    }

    /**
     * 管理员处理审批消息和更新用户信息
     *
     * @param applyForBusiness
     * @return
     */
    @PostMapping("/dealApplyInfoAndUpdateUser")
    @ResponseBody
    public Result dealApplyInfoAndUpdateUser(@RequestBody ApplyForBusiness applyForBusiness) {
        return applyForBusinessService.dealApplyInfoAndUpdateUser(applyForBusiness);
    }

    /**
     * 管理员删除 申请记录
     * @param id
     * @return
     */
    @PostMapping("/deleteById")
    @ResponseBody
    public Result deleteById(@RequestParam("id") Integer id) {
        int i = applyForBusinessService.deleteByPrimaryKey(id);
        if (i > 0) {
            return ResultUtil.success(ResultEnum.SUCCESS);
        } else {
            return ResultUtil.error(ResultEnum.FAILE);
        }
    }
}

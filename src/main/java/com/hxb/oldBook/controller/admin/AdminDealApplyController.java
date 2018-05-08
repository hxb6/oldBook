package com.hxb.oldBook.controller.admin;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.common.TablePageResult;
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
     * 根据分页得到数据记录
     * @param offset 第几条记录
     * @param limit 前台设置的每页多少条记录
     * @return
     */
    @GetMapping("/getAllApplyForBusiness")
    @ResponseBody
    public TablePageResult selectAllApplyForBusiness(Integer offset,Integer limit){
        List<ApplyForBusiness> lists = applyForBusinessService.queryByPage(offset, limit);
        Integer total = applyForBusinessService.getCount(new ApplyForBusiness());
        if (lists != null && lists.size() > 0){
            return TablePageResultUtil.success(total, lists);
        } else {
            return null;
        }
    }

    /**
     * 管理员处理审批消息和更新用户信息
     * @param applyForBusiness
     * @return
     */
    @PostMapping("/dealApplyInfoAndUpdateUser")
    @ResponseBody
    public Result dealApplyInfoAndUpdateUser(@RequestBody ApplyForBusiness applyForBusiness){
        return applyForBusinessService.dealApplyInfoAndUpdateUser(applyForBusiness);
    }
}

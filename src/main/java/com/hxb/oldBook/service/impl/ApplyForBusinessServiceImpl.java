package com.hxb.oldBook.service.impl;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.mapper.ApplyForBusinessMapper;
import com.hxb.oldBook.pojo.ApplyForBusiness;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.ApplyForBusinessService;
import com.hxb.oldBook.utils.RequestUtil;
import com.hxb.oldBook.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Package: com.hxb.oldBook.service.impl
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 14:59
 * @Description:
 **/
@Service
public class ApplyForBusinessServiceImpl extends BaseServiceImpl<ApplyForBusiness> implements ApplyForBusinessService {

    /**
     * 注入ApplyForBusinessMapper对象
     */
    @Autowired
    private ApplyForBusinessMapper applyForBusinessMapper;

    /**
     * 申请成为商家接口
     *
     * @param applyForBusiness
     * @return
     */
    @Override
    public Result applyToBeBusiness(ApplyForBusiness applyForBusiness) {
        //获取会话session
        HttpSession session = RequestUtil.getSession();
        //获取用户id 作为申请成为商家的用户id  userId属性
        Integer userId = ((User) session.getAttribute("user")).getId();
        //用户申请成为商家的时间
        applyForBusiness.setApplyTime(new Date());
        //审批状态 默认未审批(0)
        applyForBusiness.setStatus(((short) 0));
        //审批消息 默认为"管理员正在审批中..."
        applyForBusiness.setReturnMessage("管理员正在审批中...");
        //绑定审批人的主键id
        applyForBusiness.setUserId(userId);
        //调用Mapper接口的insertSelective方法
        // 对象属性为null的不会保存,会使用数据库设计时默认的值
        applyForBusinessMapper.insertSelective(applyForBusiness);
        return ResultUtil.success(ResultEnum.SUCCESS, applyForBusiness);
    }

    /**
     * 根据用户主键查询其申请成为商家的记录
     *
     * @param userId
     * @return
     */
    @Override
    public Result queryByUserId(Integer userId) {
        if (userId != null) {
            ApplyForBusiness applyForBusiness = applyForBusinessMapper.queryByUserId(userId);
            return ResultUtil.success(ResultEnum.SUCCESS, applyForBusiness);
        }
        return null;
    }

    /**
     * 分页查询数据
     *
     * @param offset 从第几条记录开始查询
     * @param limit  每页的记录数
     * @return
     */
    @Override
    public List<ApplyForBusiness> queryByPage(Integer offset, Integer limit) {
        return applyForBusinessMapper.queryByPage(offset, limit);
    }
}

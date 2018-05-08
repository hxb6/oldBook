package com.hxb.oldBook.service.impl;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.ResultEnum;
import com.hxb.oldBook.mapper.ApplyForBusinessMapper;
import com.hxb.oldBook.mapper.UserMapper;
import com.hxb.oldBook.pojo.ApplyForBusiness;
import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.service.ApplyForBusinessService;
import com.hxb.oldBook.utils.ResultUtil;
import com.hxb.oldBook.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public static final String RETURN_MESSAGE_SUCCESS = "审批合格";
    /**
     * 注入ApplyForBusinessMapper对象
     */
    @Autowired
    private ApplyForBusinessMapper applyForBusinessMapper;

    /**
     * 注入UserMapper对象
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 申请成为商家接口
     *
     * @param applyForBusiness
     * @return
     */
    @Override
    public Result applyToBeBusiness(ApplyForBusiness applyForBusiness) {
        //获取用户id与用户姓名 作为申请成为商家的用户id  userId属性 与applyPersonName属性
        User user = UserUtil.getUserFormSession();
        //绑定审批人的主键id
        applyForBusiness.setUserId(user.getId());
        //申请人姓名
        applyForBusiness.setApplyPersonName(user.getUserName());
        //用户申请成为商家的时间
        applyForBusiness.setApplyTime(new Date());
        //默认该条信息可用
        applyForBusiness.setIsActive(true);
        //审批状态 默认未审批(0)
        applyForBusiness.setStatus(((short) 0));
        //审批消息 默认为"管理员正在审批中..."
        applyForBusiness.setReturnMessage("管理员正在审批中...");
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

    /**
     * 管理员处理审批消息和更新用户信息
     * 可能要更新两张表 所以要事务管理
     *
     * @param applyForBusiness
     * @return
     */
    @Transactional
    @Override
    public Result dealApplyInfoAndUpdateUser(ApplyForBusiness applyForBusiness) {
        //设置管理员审批时间
        applyForBusiness.setApprovalTime(new Date());
        //获取申请人id
        Integer userId = applyForBusiness.getUserId();
        /*
            判断审批状态
            1-设置申请人是否是商家标志为true,并且设置新的回执消息为"审批合格"
            2-申请人不做处理,审批消息为页面传递过来的也不用做处理
         */
        Short status = applyForBusiness.getStatus();
        //申请通过
        if (status == 1) {
            User user = userMapper.selectByPrimaryKey(userId);
            //设置是否是商家标志 为true 用户成为商家
            user.setIsMerchant(true);
            applyForBusiness.setReturnMessage(RETURN_MESSAGE_SUCCESS);
            //更新用户与审批消息记录
            applyForBusinessMapper.updateByPrimaryKeySelective(applyForBusiness);
            userMapper.updateByPrimaryKeySelective(user);
            return ResultUtil.success(ResultEnum.SUCCESS);
        } else {
            //审批不通过
            applyForBusinessMapper.updateByPrimaryKeySelective(applyForBusiness);
            return ResultUtil.success(ResultEnum.SUCCESS);
        }
    }

    /**
     * 更新申请信息记录变为不可被使用
     * 当用户第一次申请审批不合格后 点击再次申请时会先将原来的记录状态设置为0表示不可用
     * @param applyForBusiness
     * @return
     */
    @Override
    public int updateNotActive(ApplyForBusiness applyForBusiness) {
        return applyForBusinessMapper.updateByPrimaryKeySelective(applyForBusiness);
    }
}

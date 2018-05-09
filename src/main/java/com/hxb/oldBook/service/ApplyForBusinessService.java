package com.hxb.oldBook.service;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.ApplyForBusiness;

import java.util.List;

/**
 * @Package: com.hxb.oldBook.service
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 14:58
 * @Description: 申请成为商家接口
 **/
public interface ApplyForBusinessService extends BaseService<ApplyForBusiness> {

    /**
     * 申请成为商家接口
     * @param applyForBusiness
     * @return
     */
    Result applyToBeBusiness(ApplyForBusiness applyForBusiness);


    /**
     * 根据用户主键查询其申请成为商家的记录
     * @param userId
     * @return
     */
    Result queryByUserId(Integer userId);

    /**
     * 根据表格参数得到对应记录
     * 得到未审批的记录 status = 0
     * @param tableParams 表格参数对象
     * @return 返回满足条件的数据集合
     */
    List<ApplyForBusiness> queryByPage(TableParams tableParams);

    /**
     * 管理员处理审批消息和更新用户信息
     * @param applyForBusiness
     * @return
     */
    Result dealApplyInfoAndUpdateUser(ApplyForBusiness applyForBusiness);

    /**
     * 更新申请信息记录不可被使用
     * @param applyForBusiness
     * @return
     */
    int updateNotActive(ApplyForBusiness applyForBusiness);

    /**
     * 根据记录是否可悲查询得到相应记录总和
     * @param isActive
     * @return
     */
    Integer getCountByIsActive(Integer isActive);
}

package com.hxb.oldBook.service;

import com.hxb.oldBook.common.Result;
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
     * 分页查询数据
     * @param offset  从第几条记录开始查询
     * @param limit 每页的记录数
     * @return
     */
    List<ApplyForBusiness> queryByPage(Integer offset,Integer limit);
}

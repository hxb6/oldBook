package com.hxb.oldBook.mapper;

import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.ApplyForBusiness;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ApplyForBusinessMapper extends Mapper<ApplyForBusiness> {
    /**
     * 根据用户id查询其申请成为商家的记录
     * @param userId
     * @return
     */
    ApplyForBusiness queryByUserId(@Param("userId") Integer userId);

    /**
     * 根据表格参数得到对应记录
     * 得到未审批的记录 status = 0
     * @param tableParams 表格参数对象
     * @return 返回满足条件的数据集合
     */
    List<ApplyForBusiness> queryByPage(TableParams tableParams);

    /**
     * 根据记录是否可被查询得到相应记录总和
     * @param isActive
     * @return
     */
    Integer getCountByIsActive(Integer isActive);
}
package com.hxb.oldBook.mapper;

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
     * 分页查询
     * @param num 从第几条记录开始查询
     * @param pageSize 查询多少条记录
     * @return
     */
    List<ApplyForBusiness> queryByPage(@Param("num") Integer num, @Param("pageSize") Integer pageSize);
}
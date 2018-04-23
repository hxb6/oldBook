package com.hxb.oldbook.service;


import java.io.Serializable;
import java.util.List;

/**
 * @Package: com.hxb.oldbook.service
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 14:28
 * @Description: 公共接口 定义简单的增删改查语句
 **/
public interface BaseService<T>{

    /**
     * 新增一个对象
     * @param object
     * @return 影响数据库表的条数
     */
    int insert(T object);

    /**
     * 根据id删除一个对象
     * @param id
     * @return 影响数据库表的条数
     */
   int deleteByPrimaryKey(Serializable id);

    /**
     * 根据id得到一个对象
     * @param id
     * @return
     */
   T selectByPrimaryKey(Serializable id);


    /**
     * 查询所有记录
     * @return 对象集合
     */
   List<T> selectAll();

}

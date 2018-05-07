package com.hxb.oldBook.service.impl;

import com.hxb.oldBook.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.List;

/**
 * @Package: com.hxb.oldBook.service.impl
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 14:43
 * @Description:
 **/
public class BaseServiceImpl<T> implements BaseService<T> {

    /**
     * 注入tk通用mapper接口对象
     */
    @Autowired
    private Mapper<T> mapper;

    /**
     * 调用Mapper接口的insertSelective方法,对象属性为null的不会保存,会使用数据库设计时默认的值
     * @param object
     * @return 成功影响数据库记录的条数
     */
    @Override
    public int insert(T object) {
        return mapper.insertSelective(object);
    }

    /**
     * 根据id删除一条记录
     * @param id
     * @return 成功影响数据库记录的条数
     */
    @Override
    public int deleteByPrimaryKey(Serializable id) {
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id得到一个对象
     * @param id
     * @return 查询的对象
     */
    @Override
    public T selectByPrimaryKey(Serializable id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有对象
     * @return 对象结合
     */
    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }


    /**
     * 调用mapper的updateByPrimaryKeySelective的方法 根据主键更新属性不为null的值
     * @param object
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(T object) {
        return mapper.updateByPrimaryKeySelective(object);
    }

    /**
     * 得到数据总数
     *
     * @return
     */
    @Override
    public int getCount(T object) {
        return mapper.selectCount(object);
    }
}

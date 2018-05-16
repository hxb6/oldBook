package com.hxb.oldBook.mapper;

import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    /**
     * 通过用户账号得到用户对象
     *
     * @param userAccount 用户账号
     * @return 用户对象
     */
    User selectUserByUserAccount(@Param("userAccount") String userAccount);

    /**
     *根据TableParams得到对应用户数据
     * @param tableParams
     * @return
     */
    List<User> getUserByTableParams(TableParams tableParams);

    /**
     * 得到用户对象 名字升序排序
     * @return
     */
    List<User> getUserList();
}
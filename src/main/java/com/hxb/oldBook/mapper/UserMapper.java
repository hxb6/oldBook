package com.hxb.oldBook.mapper;

import com.hxb.oldBook.pojo.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    /**
     * 通过用户账号得到用户对象
     *
     * @param userAccount 用户账号
     * @return 用户对象
     */
    User selectUserByUserAccount(@Param("userAccount") String userAccount);
}
package com.hxb.oldBook.service;

import com.hxb.oldBook.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Package: com.hxb.oldBook.service
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/23 14:48
 * @Description: 用户接口
 **/
public interface UserService extends BaseService<User> {


    /**
     * 通过用户账号得到用户接口
     * @param userAccount 用户账号
     * @return 用户对象
     */
    User selectUserByUserAccount(@Param("userAccount") String userAccount);
}

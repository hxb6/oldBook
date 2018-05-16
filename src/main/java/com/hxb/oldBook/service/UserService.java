package com.hxb.oldBook.service;

import com.hxb.oldBook.common.Result;
import com.hxb.oldBook.common.TableParams;
import com.hxb.oldBook.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 用户注册
     * @param userAccount 用户账号
     * @param password 用户密码
     * @return 用户对象
     */
    Result register(String userAccount,String password);

    /**
     * 用户登录
     * @param userAccount 用户账号
     * @param password 用户密码
     * @return 封装成结果集
     */
    Result login (String userAccount,String password);

    /**
     * 修改密码
     * @param id 用户id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 封装成结果集
     */
    Result changePassword(Integer id,String oldPassword,String newPassword);

    /**
     * 修改密保问题与密保答案
     * @param encryptedProblem 密保问题
     * @param encryptedQuestion 密保答案
     * @return 最新的User对象
     */
    User changeEncrypted(String encryptedProblem,String encryptedQuestion);

    /**
     * 重置密码成123456普通用户需要校验密保问题 管理员可直接重置
     * @param encryptedQuestion
     * @return Result结果集
     */
    Result resetPassword(String encryptedQuestion);

    /**
     * 重置密码成123456 管理员调用
     * @param id 用户id
     * @return Result结果集
     */
    Result adminResetUserPassword(Integer id);

    /**
     * 根据TableParams得到对应用户数据
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

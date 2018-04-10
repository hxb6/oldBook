package com.hxb.oldbook.pojo;

import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户登录账号 10位字符  英文和数字组合
     */
    @Column(name = "user_account")
    private String userAccount;

    /**
     * 用户姓名(2~3个汉字) 默认为 xx同学 
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户密码 
     */
    private String password;

    /**
     * 用户角色 0-管理员  1-用户
     */
    @Column(name = "role_type")
    private Byte roleType;

    /**
     * 是否是商家(只考虑用户) 0-不是  1-是
     */
    @Column(name = "is_merchant")
    private Boolean isMerchant;

    /**
     * 注册成为用户的时间
     */
    @Column(name = "user_register_time")
    private Date userRegisterTime;

    /**
     * 用户注册成为商家的时间
     */
    @Column(name = "register_merchant_time")
    private Date registerMerchantTime;

    /**
     * 用户信息最近修改的时间
     */
    @Column(name = "user_modified_time")
    private Date userModifiedTime;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户登录账号 10位字符  英文和数字组合
     *
     * @return user_account - 用户登录账号 10位字符  英文和数字组合
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 设置用户登录账号 10位字符  英文和数字组合
     *
     * @param userAccount 用户登录账号 10位字符  英文和数字组合
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    /**
     * 获取用户姓名(2~3个汉字) 默认为 xx同学 
     *
     * @return user_name - 用户姓名(2~3个汉字) 默认为 xx同学 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名(2~3个汉字) 默认为 xx同学 
     *
     * @param userName 用户姓名(2~3个汉字) 默认为 xx同学 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取用户密码 
     *
     * @return password - 用户密码 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码 
     *
     * @param password 用户密码 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户角色 0-管理员  1-用户
     *
     * @return role_type - 用户角色 0-管理员  1-用户
     */
    public Byte getRoleType() {
        return roleType;
    }

    /**
     * 设置用户角色 0-管理员  1-用户
     *
     * @param roleType 用户角色 0-管理员  1-用户
     */
    public void setRoleType(Byte roleType) {
        this.roleType = roleType;
    }

    /**
     * 获取是否是商家(只考虑用户) 0-不是  1-是
     *
     * @return is_merchant - 是否是商家(只考虑用户) 0-不是  1-是
     */
    public Boolean getIsMerchant() {
        return isMerchant;
    }

    /**
     * 设置是否是商家(只考虑用户) 0-不是  1-是
     *
     * @param isMerchant 是否是商家(只考虑用户) 0-不是  1-是
     */
    public void setIsMerchant(Boolean isMerchant) {
        this.isMerchant = isMerchant;
    }

    /**
     * 获取注册成为用户的时间
     *
     * @return user_register_time - 注册成为用户的时间
     */
    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    /**
     * 设置注册成为用户的时间
     *
     * @param userRegisterTime 注册成为用户的时间
     */
    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    /**
     * 获取用户注册成为商家的时间
     *
     * @return register_merchant_time - 用户注册成为商家的时间
     */
    public Date getRegisterMerchantTime() {
        return registerMerchantTime;
    }

    /**
     * 设置用户注册成为商家的时间
     *
     * @param registerMerchantTime 用户注册成为商家的时间
     */
    public void setRegisterMerchantTime(Date registerMerchantTime) {
        this.registerMerchantTime = registerMerchantTime;
    }

    /**
     * 获取用户信息最近修改的时间
     *
     * @return user_modified_time - 用户信息最近修改的时间
     */
    public Date getUserModifiedTime() {
        return userModifiedTime;
    }

    /**
     * 设置用户信息最近修改的时间
     *
     * @param userModifiedTime 用户信息最近修改的时间
     */
    public void setUserModifiedTime(Date userModifiedTime) {
        this.userModifiedTime = userModifiedTime;
    }
}
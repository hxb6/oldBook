package com.hxb.oldBook.utils;

import org.springframework.util.DigestUtils;
/**
 * @package: com.hxb.oldBook.utils
 * @author: HeXiaoBo
 * @date: 2018-04-023 17:20
 * @description: MD5加密工具类
 **/

public class MD5Util {

    /**
     * 私有化构造函数
     */
    private MD5Util() {
    }


    /**
     * 从SLAT产生8位数的盐
     * 盐即随机字符串
     */
    public static final String SALT = "0123456789abcdefghijklmnopqrstuvwxyz";

    /**
     * 获取MD5加密
     * 利用Apache commons的DigestUtils工具类进行MD5加密
     *
     * @param password 明文密码+盐
     * @return MD5加密后的密码
     */
    public static String getPassword(String password) {
        byte[] bytes = password.getBytes();
        return DigestUtils.md5DigestAsHex(bytes);
    }

    /**
     * 产生并返回8位数的盐
     *
     * @return 盐
     */
    public static String getSalt() {
        String salt = "";
        for (int i = 0; i < 8; i++) {
            //产生0到SALT长度之间的随机整数作为charAt的index获取随机的字符
            int random = ((int) (Math.random() * SALT.length()));
            salt += SALT.charAt(random);
        }
        return salt;
    }
}

package com.hxb.oldBook.utils;

import java.util.Arrays;

/**
 * @Package: com.hxb.oldBook.utils
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/9 16:04
 * @Description: 字符串工具包
 **/
public class StringUtil {

    public static String humpToUnderline(String str) {
        //新建可变字符串对象
        StringBuffer sb = new StringBuffer();
        if (str != null) {
            //遍历字符串
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                //如果字符是大写的 sb追加为下划线加其小写状态 否则 追加原来的字符
                if (Character.isUpperCase(c)) {
                    sb.append("_" + Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
        return null;
    }

}

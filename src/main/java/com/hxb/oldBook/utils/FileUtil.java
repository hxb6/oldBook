package com.hxb.oldBook.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Package: com.hxb.oldBook.utils
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/16 9:56
 * @Description: 文件工具类
 **/
public class FileUtil {

    /**
     * MultipartFile文件对象上传
     * @return
     */
    public static Boolean multipartFileUpload(MultipartFile multipartFile,File file) throws IOException {
        //判断文件的父目录是否存在 不存在先创建父目录
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        multipartFile.transferTo(file);
        return true;
    }

}

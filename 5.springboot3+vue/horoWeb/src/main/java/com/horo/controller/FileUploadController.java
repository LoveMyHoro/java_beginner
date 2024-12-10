package com.horo.controller;

import com.horo.utils.AliOssUtil;
import com.horo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName FileUploadController
 * @Author iove
 * @Date 2024/11/13 下午7:10
 * @Version 1.0
 * @Description TODO 这个是向阿里oss存储数据
 **/
public class FileUploadController {
    public static String upload(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename()+"开始上传");
        //1.获取原文件名
        String originalFilename = file.getOriginalFilename();
        //2.生成uuid
        String fileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //3.利用阿里oos工具类上传文件
        String url= AliOssUtil.uploadFile(fileName,file.getInputStream());
        //4.调用音乐文件数据库

        return url;
    }
}

package com.horo.controller;

import com.horo.utils.AliOssUtil;
import com.horo.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName FileUploadController
 * @Author iove
 * @Date 2024/11/4 下午8:07
 * @Version 1.0
 * @Description TODO
 **/
@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        //1.获得文件原名
        String originalFilename = file.getOriginalFilename();
        //2.生成uuid，保证文件名唯一
        String filename= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //3.利用阿里oos工具类上传文件
        String url = AliOssUtil.uploadFile(filename, file.getInputStream());
        return Result.ok(url);
    }
}

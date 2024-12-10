package com.horo.utils;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
//七牛工具类
@Service
public class QiniuUtils {
    private static final Logger logger = LoggerFactory.getLogger(QiniuUtils.class);

    // 设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "hkVRCEMPkON-3Xs93K6p2rvxdEqIPMjkrmJllhNq";
    String SECRET_KEY = "fUGSi1l8i3JaYjG1MLVxbsoJzVlG2LDBbafwXtvj";

    // 要上传的空间（创建空间的名称）
    String bucketname = "horoweb";

    // 密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    // 构造一个带指定Zone对象的配置类,不同的七牛云存储区域调用不同的zone
    Configuration cfg = new Configuration(Zone.zone1());
    UploadManager uploadManager = new UploadManager(cfg);

    // 使用的是测试域名
    private static String QINIU_IMAGE_DOMAIN = "smzkcby9p.hb-bkt.clouddn.com";

    // 获取上传token
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    // 上传文件方法，支持多种文件类型
// 上传文件方法，支持多种文件类型
    public String saveFile(MultipartFile file) throws IOException {
        try {
            // Get the file extension
            int dotPos = file.getOriginalFilename().lastIndexOf(".");
            if (dotPos < 0) {
                return null; // Return null if there's no extension
            }
            String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();

            // Check if the file extension is allowed
            if (!FileUtil.isFileAllowed(fileExt)) {
                return null; // Return null if the extension is not allowed
            }

            // Generate a unique filename
            String fileName = UUID.randomUUID().toString().replace("-", "") + "." + fileExt;

            // Upload the file and get the response
            Response res = uploadManager.put(file.getBytes(), fileName, getUpToken());

            // Check if the upload was successful
            if (res.isOK() && res.isJson()) {
                // Return the complete URL of the uploaded file with HTTP protocol
                String key = JSONObject.parseObject(res.bodyString()).getString("key");
                return "http://" + QINIU_IMAGE_DOMAIN + "/" + key; // Ensure a "/" before the key
            } else {
                logger.error("七牛异常: " + res.bodyString());
                return null; // Return null if upload failed
            }
        } catch (QiniuException e) {
            // Log the exception message
            logger.error("七牛异常: " + e.getMessage());
            return null; // Return null indicates upload failure
        }
    }

}
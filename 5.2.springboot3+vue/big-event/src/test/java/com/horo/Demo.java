package com.horo;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;

public class Demo {
    public static void main(String[] args) throws Exception {
        // Endpoint以华北（北京）为例，其它 Region 请按实际情况填写。
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        // 填写密钥和密码
        String ACCESS_KEY_ID = "LTAI5tN3rJ6tPK2q5XHV4SMb";
        String ACCESS_KEY_SECRET = "xXPsHgNXyoQGTroVXVxCHjjflVg3Bc";
        // 填写 Bucket 名称
        String bucketName = "horo-event";
        // 填写 Object 完整路径，完整路径中不能包含 Bucket 名称。
        String objectName = "001.png";
        // 填写 Bucket 所在地域。以华东 1（杭州）为例，Region 填写为 cn-hangzhou。
        String region = "cn-beijing"; // 根据实际情况修改区域名称
        // 创建 OSSClient 实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        try {
            // 填写字符串。
            String content = "Hello OSS，你好世界";

            // 创建 PutObjectRequest 对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new FileInputStream("C:\\Users\\iove\\OneDrive\\桌面\\springboot\\file\\001.png"));

            // 上传字符串。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ossClient!= null) {
                ossClient.shutdown();
            }
        }
    }
}
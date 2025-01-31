package com.horo.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
//阿里云工具类
public class AliOssUtil {

        // Endpoint以华北（北京）为例，其它 Region 请按实际情况填写。
        private static final String ENDPOINT = "https://oss-cn-beijing.aliyuncs.com";
        // 填写密钥和密码
        private static final String ACCESS_KEY_ID = "LTAI5tN3rJ6tPK2q5XHV4SMb";
        private static final String ACCESS_KEY_SECRET = "xXPsHgNXyoQGTroVXVxCHjjflVg3Bc";
        // 填写 Bucket 名称
        private static final String BUCKET_NAME = "horo-event";

    /**
     *
     * @param objectName 存储到云端的文件名
     * @param inputStream 要上传的文件输入流
     * @return 返回的是上传到云端文件的url
     * @throws Exception
     */
    //上传文件,返回文件的公网访问地址
    public static String uploadFile(String objectName, InputStream inputStream){

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT,ACCESS_KEY_ID,ACCESS_KEY_SECRET);
        //文件存储在云端的访问地址
        String url = "";
        try {
            // 创建存储空间。
            ossClient.createBucket(BUCKET_NAME);
            //上传文件
            ossClient.putObject(BUCKET_NAME, objectName, inputStream);
            //url组成：https://bucket名称.区域节点/objectName
            url = "https://"+BUCKET_NAME+"."+ENDPOINT.substring(ENDPOINT.lastIndexOf("/")+1)+"/"+objectName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url;
    }
}
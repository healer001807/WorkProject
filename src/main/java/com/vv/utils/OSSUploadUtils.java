package com.vv.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * @author kw
 * @program WorkProject
 * @description OSS文件上传
 * @create 2023 - 05 - 25 21:15
 **/
@Slf4j
@Component
public class OSSUploadUtils {

    @Autowired
    private UploadManager uploadManager; // 七牛云上传管理

    @Value("${oss.accessKey}")
    private String accessKey; // 公钥
    @Value("${oss.secretKey}")
    private String secretKey; // 私钥
    @Value("${oss.bucketName}")
    private String bucketName; // 空间名

    /***
     * @description 根据文件名和地址上传
     * @param fileName, uploadPath
     * @return java.lang.String
     * @author
     * @date 2023/5/25
     **/

    public String upload(String fileName, String uploadPath) {
        try {
            String key = null; // 默认不指定key 上传后文件名
            if (StrUtil.isNotBlank(fileName)) {
                key = fileName;
            }
            Auth auth = Auth.create(accessKey, secretKey);
            String uploadToken = auth.uploadToken(bucketName);
            // 上传
            Response resp = uploadManager.put(uploadPath, key, uploadToken);
            // 解析上传结果
            JSONObject parseObj = JSONUtil.parseObj(resp.bodyString());
            log.info("响应信息" + parseObj);
            return JSONUtil.toJsonPrettyStr(parseObj);
        } catch (QiniuException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * @description 文件流上传
     * @param fileName, inputStream
     * @return java.lang.String
     * @author
     * @date 2023/5/25
     **/

    public String upload(String fileName, InputStream inputStream) {
        try {
            String key = null; // 默认不指定key 上传后文件名
            if (StrUtil.isNotBlank(fileName)) {
                key = fileName;
            }
            Auth auth = Auth.create(accessKey, secretKey);
            String uploadToken = auth.uploadToken(bucketName);
            // 上传
            Response resp = uploadManager.put(inputStream, key, uploadToken, null, null);
            // 解析上传结果
            JSONObject parseObj = JSONUtil.parseObj(resp.bodyString());
            log.info("响应信息" + parseObj);
            return JSONUtil.toJsonPrettyStr(parseObj);
        } catch (QiniuException e) {
            throw new RuntimeException(e);
        }
    }
}

package cn.edu.njust.dev.ses.main.service;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

@Service
public class AliyunSupport {
    @Value("${aliyun.ufile.access-key-id}")
    private String accessKeyId;
    @Value("${aliyun.ufile.access-key-secret}")
    private String accessKeySecret;
    @Value("${aliyun.ufile.endpoint}")
    private String endpoint;
    @Value("${aliyun.ufile.bucket-name}")
    private String bucketName;


    public String upload(InputStream input, String fileName) {
        String generatedFileName;
        String[] fileSplitter = fileName.split("\\.");
        if (fileSplitter.length > 1) {
            generatedFileName = UUID.randomUUID().toString() + "." + fileSplitter[fileSplitter.length - 1];
        } else {
            throw new IllegalArgumentException("fileName is illegal.");
        }
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, generatedFileName, input);
        Date expiration = new Date(new Date().getTime() + 3600 * 1000 * 24 * 365 * 10);
        URL url = ossClient.generatePresignedUrl(bucketName, generatedFileName, expiration);
        ossClient.shutdown();
        return url.toString();
    }
}

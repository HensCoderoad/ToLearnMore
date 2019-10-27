package com.shiro.jpa.utils;

import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * fastdfs文件上传
 * 配置 spring.servlet.multipart: max-file-size: 10MB max-request-size: 10MB
 * fdfs: thumb-image: width:150 height:150 tracker-list: -192.168.20.252.22122
 */
public class FastdfsFileupLoad {
    @Resource
    public DefaultFastFileStorageClient fastFileStorageClient;
    @Resource
    public ThumbImageConfig thumbImageConfig;

    public String upload(HttpServletRequest request, MultipartFile file) throws IOException {
        String substring = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), substring, null);
//        StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), null);
        String thumbImagePath = thumbImageConfig.getThumbImagePath(storePath.getFullPath());
        return "success";
    }
}

package com.hua.store.service;

import com.hua.store.common.utils.FtpUtil;
import com.hua.store.common.utils.IdUtil;
import org.aspectj.util.FileUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {


    @Value("${ftp.host}")
    private String ftpHost;

    @Value("${ftp.port}")
    private Integer ftpPort;

    @Value("${ftp.username}")
    private String ftpUsername;

    @Value("${ftp.password}")
    private String ftpPassword;

    @Value("${ftp.base.dir}")
    private String ftpBaseDir;

    @Value("${base.url}")
    private String baseUrl;


    @Override
    public Map upload(MultipartFile file) {

        Map responseMap = new HashMap();
        String originalFileName = file.getOriginalFilename();

        String newFileName = IdUtil.genImageName() + originalFileName.substring(originalFileName.lastIndexOf("."));

        String filePath = new DateTime().toString("/yyyy/MM/dd");

        try {
            boolean result = FtpUtil.upload(ftpHost, ftpPort, ftpUsername, ftpPassword, ftpBaseDir, filePath, newFileName, file.getInputStream());

            if (result) {
                responseMap.put("error", 0);
                responseMap.put("url", baseUrl + filePath + "/" + newFileName);
                return responseMap;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            responseMap.put("error", 1);
            responseMap.put("message", "upload failed");
        return responseMap;
    }
}

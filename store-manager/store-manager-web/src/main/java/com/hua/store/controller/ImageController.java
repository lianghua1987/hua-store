package com.hua.store.controller;

import com.hua.store.common.utils.JsonUtils;
import com.hua.store.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("image/upload")
    @ResponseBody
    public String upload(MultipartFile multipartFile) { // must match filePostName  : "multipartFile" in common.js
        return JsonUtils.objectToJson(imageService.upload(multipartFile));
    }
}

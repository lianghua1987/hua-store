package com.hua.store.controller;


import com.hua.store.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;


    @RequestMapping("image/upload")
    @ResponseBody
    public Map upload(MultipartFile multipartFile){ // must match filePostName  : "multipartFile" in common.js
        return imageService.upload(multipartFile);
    }
}

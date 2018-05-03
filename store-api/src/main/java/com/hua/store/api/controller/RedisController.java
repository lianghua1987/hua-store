package com.hua.store.api.controller;

import com.hua.store.api.service.RedisService;
import com.hua.store.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cache/sync")
public class RedisController {

    @Autowired
    private RedisService service;

    @RequestMapping("/content/{contentCategoryId}")
    @ResponseBody
    public Result syncContent(@PathVariable Long contentCategoryId) {
        return service.syncContent(contentCategoryId);
    }
}

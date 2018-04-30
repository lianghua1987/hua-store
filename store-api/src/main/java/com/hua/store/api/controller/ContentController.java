package com.hua.store.api.controller;

import com.hua.store.api.service.ContentService;
import com.hua.store.common.pojo.Result;
import com.hua.store.common.utils.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentController {

    @Autowired
    private ContentService service;

    @RequestMapping("/content/list/{contentCategoryId}")
    @ResponseBody
    public Result getAll(@PathVariable Long contentCategoryId) {
        try {
            return Result.OK(service.getAll(contentCategoryId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
}

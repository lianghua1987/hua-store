package com.hua.store.controller;

import com.hua.store.common.pojo.EUDataGridResult;
import com.hua.store.common.pojo.Result;
import com.hua.store.pojo.Content;
import com.hua.store.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Duration;
import java.time.LocalDateTime;

@Controller
public class ContentController {

    @Autowired
    private ContentService service;

    @RequestMapping("/content/query")
    @ResponseBody
    public EUDataGridResult getAll(Integer page, Integer rows, @RequestParam Long categoryId) {
        LocalDateTime start = LocalDateTime.now();
        EUDataGridResult euDataGridResult = service.getAll(page, rows, categoryId);
        System.out.println("Item getAll - duration in millis: " + Duration.between(start, LocalDateTime.now()).toMillis());
        return euDataGridResult;
    }

    @RequestMapping(value = "/content", method = RequestMethod.POST)
    @ResponseBody
    public Result add(Content content) {
        return service.add(content);
    }

}

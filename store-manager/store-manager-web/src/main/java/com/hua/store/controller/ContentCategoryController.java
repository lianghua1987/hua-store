package com.hua.store.controller;

import com.hua.store.common.pojo.EUTreeNode;

import java.util.List;

import com.hua.store.common.pojo.Result;
import com.hua.store.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/content/category")
@ResponseBody
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<EUTreeNode> getAll(@RequestParam(value = "id", defaultValue = "0") long parentId) {
        return service.getAll(parentId);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Result add(Long parentId, String name) {
        return service.add(parentId, name);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result add(Long parentId, Long id) {
        return service.delete(parentId, id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(Long id, String name) {
        return service.update(id, name);
    }
}

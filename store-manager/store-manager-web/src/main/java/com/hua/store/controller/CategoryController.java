package com.hua.store.controller;

import com.hua.store.common.pojo.EUTreeNode;
import com.hua.store.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private ItemCategoryService service;

    @RequestMapping("/categories")
    @ResponseBody
    public List<EUTreeNode> getCategories(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        return service.getCategories(parentId);
    }
}

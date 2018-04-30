package com.hua.store.controller;

import com.hua.store.common.pojo.EUDataGridResult;
import com.hua.store.common.pojo.Result;
import com.hua.store.pojo.ItemParameter;
import com.hua.store.service.ItemParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Duration;
import java.time.LocalDateTime;

@Controller
public class ItemParameterController {

    @Autowired
    private ItemParameterService service;

    @RequestMapping("/item/param/list")
    @ResponseBody
    public EUDataGridResult getAll(Integer page, Integer rows) {
        LocalDateTime start = LocalDateTime.now();
        EUDataGridResult euDataGridResult = service.getAll(page, rows);
        System.out.println("Item getAll - duration in millis: " + Duration.between(start, LocalDateTime.now()).toMillis());
        return euDataGridResult;
    }

    @RequestMapping("/item/param/query/category/{itemCategoryId}")
    @ResponseBody
    public Result getItemByItemCategoryId(@PathVariable Long itemCategoryId) {
        return service.getItemParameterByCategoryId(itemCategoryId);
    }

    @RequestMapping(value = "/item/param/save/{categoryId}", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@PathVariable Long categoryId, String paramData) {
        ItemParameter itemParameter = new ItemParameter();
        itemParameter.setParamData(paramData);
        itemParameter.setItemCatId(categoryId);
        return service.add(itemParameter);
    }
}

package com.hua.store.controller;

import com.hua.store.common.pojo.EUDataGridResult;
import com.hua.store.pojo.Item;
import com.hua.store.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Duration;
import java.time.LocalDateTime;

@Controller
public class ItemController {

    @Autowired
    private ItemService service;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public Item getItemById(@PathVariable Long itemId) {
        LocalDateTime start = LocalDateTime.now();
        Item item = service.getItemById(itemId);
        System.out.println("Duration in millis: " + Duration.between(start, LocalDateTime.now()).toMillis());
        return item;
    }

    @RequestMapping("/items")
    @ResponseBody
    public EUDataGridResult getAll(Integer page, Integer rows) {
        LocalDateTime start = LocalDateTime.now();
        EUDataGridResult euDataGridResult = service.getAll(page, rows);
        System.out.println("Item getAll - duration in millis: " + Duration.between(start, LocalDateTime.now()).toMillis());
        return euDataGridResult;
    }


}

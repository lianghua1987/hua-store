package com.hua.store.controller;

import com.hua.store.pojo.Item;
import com.hua.store.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public Item getItemById(@PathVariable Long itemId) {
        LocalDateTime start = LocalDateTime.now();
        Item item =  itemService.getItemById(itemId);
        System.out.println("Duration in millis: " + Duration.between(start, LocalDateTime.now()).toMillis());
        return item;
    }

}

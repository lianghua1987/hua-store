package com.hua.store.controller;

import com.hua.store.service.ItemParameterItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemParameterItemController {

    @Autowired
    private ItemParameterItemService service;

    @RequestMapping("/item/paramitem/{itemId}")
    public String getItemByItemCategoryId(@PathVariable Long itemId, Model model) {
        model.addAttribute("itemParam", service.getByItemId(itemId));
        return "item";
    }

}

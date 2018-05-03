package com.hua.store.api.controller;

import com.hua.store.api.pojo.CategoryResult;
import com.hua.store.api.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService service;

    @RequestMapping(value = "/item/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object getCategories(String callback) {
        CategoryResult result = service.getCategories();

        // After spring4.0
        MappingJacksonValue value = new MappingJacksonValue(result);
        value.setJsonpFunction(callback);
        //return callback + "(" + JsonUtils.objectToJson(result) + ")";
        return value;

    }
}

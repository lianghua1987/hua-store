package com.hua.store.portal.controller;

import com.hua.store.common.pojo.Result;
import com.hua.store.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {


    @Autowired
    private ContentService service;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("ad1", service.getContents());
        return "index";
    }


    @RequestMapping(value = "/httpclient/post", method = RequestMethod.POST)
    public String testPost(String username, String password) {
        return "username: " + username + "\npassword: ********";
    }

}

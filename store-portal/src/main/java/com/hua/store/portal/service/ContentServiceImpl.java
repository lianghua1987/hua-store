package com.hua.store.portal.service;

import com.hua.store.common.pojo.Result;
import com.hua.store.common.utils.HttpClientUtil;
import com.hua.store.common.utils.JsonUtils;
import com.hua.store.pojo.Content;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService {


    @Value("${API_URL}")
    private String BASE_URL;


    @Value("${INDEX_AD_URL}")
    private String INDEX_AD_URL;


    @Override
    public String getContents() {
        String result = HttpClientUtil.doGet(BASE_URL + INDEX_AD_URL);
        try {
            List<Content> contents = (List<Content>) Result.formatToList(result, Content.class).getData();
            List<Map> list = new ArrayList<>();
            for (Content content : contents) {
                Map map = new HashMap();
                map.put("src", content.getPic());
                map.put("height", 240);
                map.put("width", 670);
                map.put("srcB", content.getPic2());
                map.put("widthB", 550);
                map.put("heightB", 240);
                map.put("href", content.getUrl());
                map.put("alt", content.getSubTitle());
                list.add(map);
            }
            return JsonUtils.objectToJson(list);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}

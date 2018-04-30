package com.hua.store.api.service;

import com.hua.store.mapper.ContentMapper;
import com.hua.store.pojo.Content;
import com.hua.store.pojo.ContentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper mapper;

    @Override
    public List<Content> getAll(Long contentCategoryId) {
        ContentExample contentExample = new ContentExample();
        ContentExample.Criteria criteria = contentExample.createCriteria();
        criteria.andCategoryIdEqualTo(contentCategoryId);
        return mapper.selectByExample(contentExample);
    }
}

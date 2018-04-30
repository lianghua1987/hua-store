package com.hua.store.api.service;

import com.hua.store.pojo.Content;

import java.util.List;

public interface ContentService {
    public List<Content> getAll(Long contentCategoryId);
}

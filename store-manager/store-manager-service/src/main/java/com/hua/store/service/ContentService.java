package com.hua.store.service;

import com.hua.store.common.pojo.EUDataGridResult;
import com.hua.store.common.pojo.Result;
import com.hua.store.pojo.Content;

public interface ContentService {

    public EUDataGridResult getAll(Integer pageNumber, Integer pageSize, Long categoryId);

    public Result add(Content content);
}

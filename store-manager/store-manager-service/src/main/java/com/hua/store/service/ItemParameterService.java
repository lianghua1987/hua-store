package com.hua.store.service;

import com.hua.store.common.pojo.EUDataGridResult;
import com.hua.store.common.pojo.Result;
import com.hua.store.pojo.ItemParameter;

public interface ItemParameterService {
    public EUDataGridResult getAll(Integer pageNumber, Integer pageSize);

    public Result getItemParameterByCategoryId(Long categoryId);

    public Result add(ItemParameter itemParameter);
}

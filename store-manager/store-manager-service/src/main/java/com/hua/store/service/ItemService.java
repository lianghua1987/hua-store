package com.hua.store.service;

import com.hua.store.common.pojo.EUDataGridResult;
import com.hua.store.common.pojo.Result;
import com.hua.store.pojo.Item;

public interface ItemService {

    public Item getItemById(Long id);

    public EUDataGridResult getAll(Integer pageNumber, Integer pageSize);

    public Result add(Item item, String description, String paramData);
}

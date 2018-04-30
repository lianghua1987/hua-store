package com.hua.store.service;

import com.hua.store.common.pojo.EUTreeNode;
import com.hua.store.common.pojo.Result;

import java.util.List;

public interface ContentCategoryService {

    public List<EUTreeNode> getAll(long parentId);

    public Result add(long parentId, String name);

    public Result delete(long parentId, long id);

    public Result update(long id, String name);

}

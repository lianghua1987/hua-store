package com.hua.store.service;

import com.hua.store.common.pojo.EUTreeNode;

import java.util.List;

public interface ItemCategoryService {

    List<EUTreeNode> getCategories(long parentId);
}

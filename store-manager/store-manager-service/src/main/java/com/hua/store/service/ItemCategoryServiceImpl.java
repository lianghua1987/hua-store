package com.hua.store.service;

import com.hua.store.common.pojo.EUTreeNode;
import com.hua.store.mapper.ItemCategoryMapper;
import com.hua.store.pojo.ItemCategory;
import com.hua.store.pojo.ItemCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    private ItemCategoryMapper mapper;

    @Override
    public List<EUTreeNode> getCategories(long parentId) {

        ItemCategoryExample example = new ItemCategoryExample();

        ItemCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<ItemCategory> list = mapper.selectByExample(example);

        List<EUTreeNode> resultList = new ArrayList<>();

        for (ItemCategory itemCategory : list) {
            EUTreeNode node = new EUTreeNode();
            node.setId(itemCategory.getId());
            node.setText(itemCategory.getName());
            node.setState(itemCategory.getIsParent() ? "closed" : "open");
            resultList.add(node);
        }

        return resultList;
    }
}

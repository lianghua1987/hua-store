package com.hua.store.api.service;

import com.hua.store.api.pojo.CategoryNode;
import com.hua.store.api.pojo.CategoryResult;
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
    ItemCategoryMapper mapper;

    @Override
    public CategoryResult getCategories() {
        CategoryResult result = new CategoryResult();
        result.setData(getCategoryList(0l));
        return result;
    }


    public List<?> getCategoryList(long parentId) {
        ItemCategoryExample example = new ItemCategoryExample();
        ItemCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<ItemCategory> itemCategories = mapper.selectByExample(example);

        List nodes = new ArrayList<>();

        int counter = 0;
        for (ItemCategory ic : itemCategories) {

            if (ic.getIsParent()) {
                CategoryNode node = new CategoryNode();

                if (parentId == 0) {
                    node.setName("<a href ='/products/" + ic.getId() + ".html'>" + ic.getName() + "</a>");
                } else {
                    node.setName(ic.getName());
                }

                node.setUrl("products/" + ic.getId());
                node.setItem(getCategoryList(ic.getId()));
                nodes.add(node);

                counter++;
                // To show only 14 categories in portal
                if (counter >= 14 && parentId == 0) {
                    break;
                }
            } else {
                nodes.add("products/" + ic.getId() + "|" + ic.getName());
            }


        }

        return nodes;
    }
}

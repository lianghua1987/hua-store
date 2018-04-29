package com.hua.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.store.common.pojo.EUDataGridResult;
import com.hua.store.common.pojo.Result;
import com.hua.store.common.utils.IdUtil;
import com.hua.store.mapper.ItemDescriptionMapper;
import com.hua.store.mapper.ItemMapper;
import com.hua.store.mapper.ItemParameterItemMapper;
import com.hua.store.pojo.Item;
import com.hua.store.pojo.ItemDescription;
import com.hua.store.pojo.ItemExample;
import com.hua.store.pojo.ItemParameterItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemDescriptionMapper itemDescriptionMapper;

    @Autowired
    private ItemParameterItemMapper itemParameterItemMapper;

    @Override
    public Item getItemById(Long itemId) {
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<Item> items = itemMapper.selectByExample(itemExample);

        if (items != null && !items.isEmpty()) {
            return items.get(0);
        }
        return null;
    }

    @Override
    public EUDataGridResult getAll(Integer pageNumber, Integer pageSize) {
        ItemExample example = new ItemExample();
        PageHelper.startPage(pageNumber, pageSize);
        List<Item> list = itemMapper.selectByExample(example);
        return new EUDataGridResult(new PageInfo<>(list).getTotal(), list);
    }

    @Override
    public Result add(Item item, String description, String paramData) {
        Long itemId = IdUtil.genItemId();
        item.setId(itemId);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        item.setStatus((byte) 1);
        itemMapper.insert(item);

        Result result = addItemDescription(itemId, description);

        if (result.getStatus() != 200) {
            throw new RuntimeException("AddItemDescription failed.");
        }

        result = addItemParameterItem(itemId, paramData);

        if (result.getStatus() != 200) {
            throw new RuntimeException("AddItemParameterItem failed.");
        }

        return Result.OK();
    }


    private Result addItemDescription(Long itemId, String description) {
        ItemDescription itemDescription = new ItemDescription();
        itemDescription.setItemId(itemId);
        itemDescription.setItemDesc(description);
        itemDescription.setCreated(new Date());
        itemDescription.setUpdated(new Date());
        itemDescriptionMapper.insert(itemDescription);
        return Result.OK();
    }


    private Result addItemParameterItem(Long itemId, String paramData) {
        ItemParameterItem itemParameterItem = new ItemParameterItem();
        itemParameterItem.setItemId(itemId);
        itemParameterItem.setParamData(paramData);
        itemParameterItem.setUpdated(new Date());
        itemParameterItem.setCreated(new Date());
        itemParameterItemMapper.insert(itemParameterItem);
        return Result.OK();
    }
}

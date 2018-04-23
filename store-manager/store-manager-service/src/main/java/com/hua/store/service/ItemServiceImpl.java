package com.hua.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.store.common.pojo.EUDataGridResult;
import com.hua.store.mapper.ItemMapper;
import com.hua.store.pojo.Item;
import com.hua.store.pojo.ItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Item getItemById(Long itemId) {

        // itemMapper.selectByPrimaryKey(itemId);

        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<Item> items = itemMapper.selectByExample(itemExample);

        if(items != null && !items.isEmpty()){
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
}

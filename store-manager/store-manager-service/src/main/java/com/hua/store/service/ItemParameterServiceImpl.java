package com.hua.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.store.common.pojo.EUDataGridResult;
import com.hua.store.common.pojo.Result;
import com.hua.store.mapper.ItemParameterMapper;
import com.hua.store.pojo.ItemParameter;
import com.hua.store.pojo.ItemParameterExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemParameterServiceImpl implements ItemParameterService {

    @Autowired
    private ItemParameterMapper mapper;

    @Override
    public EUDataGridResult getAll(Integer pageNumber, Integer pageSize) {
        ItemParameterExample example = new ItemParameterExample();
        PageHelper.startPage(pageNumber, pageSize);
        List<ItemParameter> list = mapper.selectByExampleWithBLOBs(example);
        return new EUDataGridResult(new PageInfo<>(list).getTotal(), list);
    }

    @Override
    public Result getItemParameterByCategoryId(Long categoryId) {
        ItemParameterExample example = new ItemParameterExample();
        ItemParameterExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(categoryId);
        List<ItemParameter>  itemParameters = mapper.selectByExampleWithBLOBs(example);

        if(itemParameters != null && !itemParameters.isEmpty()){
            return Result.OK(itemParameters.get(0));
        }

        return Result.NOT_FOUND();
    }

    @Override
    public Result add(ItemParameter itemParameter) {
        itemParameter.setCreated(new Date());
        itemParameter.setUpdated(new Date());
        mapper.insert(itemParameter);
        return Result.OK();
    }

}

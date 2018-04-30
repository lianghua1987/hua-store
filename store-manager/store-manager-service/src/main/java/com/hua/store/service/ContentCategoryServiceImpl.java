package com.hua.store.service;

import com.hua.store.common.pojo.EUTreeNode;
import com.hua.store.common.pojo.Result;
import com.hua.store.mapper.ContentCategoryMapper;
import com.hua.store.pojo.ContentCategory;
import com.hua.store.pojo.ContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private ContentCategoryMapper mapper;

    @Override
    public List<EUTreeNode> getAll(long parentId) {
        ContentCategoryExample example = new ContentCategoryExample();

        ContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<ContentCategory> list = mapper.selectByExample(example);

        List<EUTreeNode> resultList = new ArrayList<>();

        for (ContentCategory cc : list) {
            resultList.add(new EUTreeNode(cc.getId(), cc.getName(), cc.getIsParent() ? "closed" : "open"));
        }

        return resultList;

    }

    @Override
    public Result add(long parentId, String name) {
        ContentCategory contentCategory = new ContentCategory();
        contentCategory.setName(name);
        contentCategory.setParentId(parentId);
        contentCategory.setIsParent(false);
        contentCategory.setStatus(1);
        contentCategory.setSortOrder(1);
        contentCategory.setUpdated(new Date());
        contentCategory.setCreated(new Date());

        mapper.insert(contentCategory);

        ContentCategory parent = mapper.selectByPrimaryKey(parentId);
        if (parent.getIsParent() == false) {
            parent.setIsParent(true);
            mapper.updateByPrimaryKey(parent);
        }
        return Result.OK(contentCategory);
    }

    @Override
    public Result delete(long parentId, long id) {

        removeSub(id);

        ContentCategoryExample example = new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<ContentCategory> list = mapper.selectByExample(example);

        if (list == null || list.isEmpty()) {
            ContentCategory parent = mapper.selectByPrimaryKey(parentId);
            parent.setIsParent(false);
            mapper.updateByPrimaryKey(parent);
            System.out.println("Parent id:" + parent + " became a leaf node.");
        }

        return Result.OK();
    }

    private void removeSub(long id) {
        ContentCategory node = mapper.selectByPrimaryKey(id);
        ContentCategoryExample example = null;
        ContentCategoryExample.Criteria criteria = null;
        List<ContentCategory> list = null;
        if (node.getIsParent()) {
            example = new ContentCategoryExample();
            criteria = example.createCriteria();
            criteria.andParentIdEqualTo(id);
            list = mapper.selectByExample(example);
            for (ContentCategory cc : list) {
                removeSub(cc.getId());
            }
        }

        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Result update(long id, String name) {
        ContentCategory cc = mapper.selectByPrimaryKey(id);
        cc.setName(name);
        mapper.updateByPrimaryKey(cc);
        return Result.OK();
    }


}

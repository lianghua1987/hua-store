package com.hua.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.store.common.pojo.EUDataGridResult;
import com.hua.store.common.pojo.Result;
import com.hua.store.common.utils.ExceptionUtil;
import com.hua.store.common.utils.HttpClientUtil;
import com.hua.store.mapper.ContentMapper;
import com.hua.store.pojo.Content;
import com.hua.store.pojo.ContentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper mapper;

    @Value("${API_URL}")
    private String BASE_URL;

    @Value("${SYNC_REST_CONTENT_RESOURCE}")
    private String SYNC_REST_CONTENT_RESOURCE;

    @Override
    public EUDataGridResult getAll(Integer pageNumber, Integer pageSize, Long categoryId) {
        ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        PageHelper.startPage(pageNumber, pageSize);
        List<Content> list = mapper.selectByExample(example);
        return new EUDataGridResult(new PageInfo<>(list).getTotal(), list);
    }

    @Override
    public Result add(Content content) {
        content.setCreated(new Date());
        content.setUpdated(new Date());
        mapper.insert(content);

        try {
            HttpClientUtil.doGet(BASE_URL + SYNC_REST_CONTENT_RESOURCE + content.getCategoryId());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, ExceptionUtil.getStackTrace(e));
        }

        return Result.OK();
    }

}

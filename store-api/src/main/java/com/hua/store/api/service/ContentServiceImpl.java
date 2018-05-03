package com.hua.store.api.service;

import com.hua.store.api.dao.JedisClient;
import com.hua.store.common.utils.JsonUtils;
import com.hua.store.mapper.ContentMapper;
import com.hua.store.pojo.Content;
import com.hua.store.pojo.ContentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper mapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${REDIS_INDEX_CONTENT_KEY}")
    private String INDEX_CONTENT_KEY;

    @Override
    public List<Content> getAll(Long contentCategoryId) {

        // retrieve from redis
        try {
            String value = jedisClient.hget(INDEX_CONTENT_KEY, Long.toString(contentCategoryId));
            if (value != null) {
                return JsonUtils.jsonToList(value, Content.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ContentExample contentExample = new ContentExample();
        ContentExample.Criteria criteria = contentExample.createCriteria();
        criteria.andCategoryIdEqualTo(contentCategoryId);
        List<Content> contents = mapper.selectByExample(contentExample);

        // add to redis
        try {
            jedisClient.hset(INDEX_CONTENT_KEY, Long.toString(contentCategoryId), JsonUtils.objectToJson(contents));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return contents;
    }
}

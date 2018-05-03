package com.hua.store.api.service;

import com.hua.store.api.dao.JedisClient;
import com.hua.store.common.pojo.Result;
import com.hua.store.common.utils.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private JedisClient client;

    @Value("${REDIS_INDEX_CONTENT_KEY}")
    private String INDEX_CONTENT_KEY;

    @Override
    public Result syncContent(long contentCategoryId) {
        try {
            return Result.OK(client.hdel(INDEX_CONTENT_KEY, Long.toString(contentCategoryId)));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
}

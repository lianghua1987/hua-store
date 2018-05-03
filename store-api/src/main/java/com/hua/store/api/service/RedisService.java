package com.hua.store.api.service;

import com.hua.store.common.pojo.Result;

public interface RedisService {

    public Result syncContent(long contentCategoryId);

}

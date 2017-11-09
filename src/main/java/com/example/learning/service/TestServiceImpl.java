package com.example.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhaoqicheng on 2017/7/11.
 */

@Service
public class TestServiceImpl extends RedisBaseService implements TestService {

    private static final String REDIS_KEY = "TEST_REDIS_KEY";

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate){
        super.redisTemplate = redisTemplate;
    }

    @Resource
    public void setHashOperations(HashOperations<String, String, Object> hashOperations){
        super.hashOperations = hashOperations;
    }

    @Override
    public String getRedisKey() {
        return REDIS_KEY;
    }
}

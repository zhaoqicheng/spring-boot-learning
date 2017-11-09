package com.example.learning.service;


import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 基类 Service 默认实现.
 *
 * @param <T>
 */
public abstract class RedisBaseService<T> implements IRedisBaseService<T> {


    protected RedisTemplate<String, T> redisTemplate;

    protected HashOperations<String, String, T> hashOperations;

    /**
     * 存入redis中的key
     *
     * @return
     */
    @Override
    public abstract String getRedisKey();

    /**
     * 添加
     *
     * @param key    key
     * @param doamin 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    @Override
    public void put(String key, T doamin, long expire) {
        hashOperations.put(getRedisKey(), key, doamin);
        if (expire != -1) {
            redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 添加 (不设置过期时间)
     *
     * @param key    key
     * @param doamin 对象
     */
    public void put(String key, T doamin) {
        put(key, doamin, -1);
    }

    /**
     * 删除
     *
     * @param key 传入key的名称
     */
    @Override
    public void remove(String key) {
        hashOperations.delete(getRedisKey(), key);
    }

    /**
     * 查询
     *
     * @param key 查询的key
     * @return
     */
    @Override
    public T get(String key) throws Exception{
        return hashOperations.get(getRedisKey(), key);
    }

    /**
     * 获取当前redis库下所有对象
     *
     * @return
     */
    @Override
    public List<T> getAll() {
        return (List<T>) hashOperations.values(getRedisKey());
    }

    /**
     * 查询查询当前redis库下所有key
     *
     * @return
     */
    @Override
    public Set<String> getKeys() {
        return hashOperations.keys(getRedisKey());
    }

    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    @Override
    public boolean isKeyExists(String key) {
        return hashOperations.hasKey(getRedisKey(), key);
    }

    /**
     * 查询当前key下缓存数量
     *
     * @return
     */
    @Override
    public long count() {
        return hashOperations.size(getRedisKey());
    }

    /**
     * 清空redis
     */
    @Override
    public void empty() {
        Set<String> set = hashOperations.keys(getRedisKey());
        set.stream().forEach(key -> hashOperations.delete(getRedisKey(), key));
    }


}

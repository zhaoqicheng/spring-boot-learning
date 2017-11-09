package com.example.learning.service;


import java.util.List;
import java.util.Set;


public interface IRedisBaseService<T> {

    /**
     * 存入redis中的key
     *
     * @return
     */
    String getRedisKey();

    /**
     * 添加
     *
     * @param key    key
     * @param doamin 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    void put(String key, T doamin, long expire);

    /**
     * 删除
     *
     * @param key 传入key的名称
     */
    void remove(String key);

    /**
     * 查询
     *
     * @param key 查询的key
     * @return
     */
    T get(String key) throws Exception;

    /**
     * 获取当前redis库下所有对象
     *
     * @return
     */
    List<T> getAll();

    /**
     * 查询查询当前redis库下所有key
     *
     * @return
     */
    Set<String> getKeys();

    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    boolean isKeyExists(String key);

    /**
     * 查询当前key下缓存数量
     *
     * @return
     */
    long count();

    /**
     * 清空redis
     */
    void empty();
}

package com.example.learning.utils;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * Created by zhaoqicheng on 2017/5/8.
 *
 * json和map以及对象相互转换工具类
 */
public class JsonXMLUtil {


    public static String obj2json(Object obj) throws Exception {
        return JSON.toJSONString(obj);
    }

    public static <T> T json2obj(String jsonStr, Class<T> clazz) throws Exception {
        return JSON.parseObject(jsonStr, clazz);
    }

    public static <T> Map<String, Object> json2map(String jsonStr) throws Exception {
        return JSON.parseObject(jsonStr, Map.class);
    }

    public static <T> T map2obj(Map<?, ?> map, Class<T> clazz) throws Exception {
        return JSON.parseObject(JSON.toJSONString(map), clazz);
    }
}


package com.example.learning.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper
 * Created by zhaoqicheng on 2017/4/17.
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
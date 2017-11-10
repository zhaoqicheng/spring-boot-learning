package com.example.learning.config;

/**
 * Created by zhaoqicheng on 2017/11/10.
 */

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
        filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                /** 忽略资源 */
                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
        }
)
public class DruidStatFilter extends WebStatFilter {
}
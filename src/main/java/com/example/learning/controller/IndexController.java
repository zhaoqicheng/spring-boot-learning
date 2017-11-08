package com.example.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhaoqicheng on 2017/5/25.
 *
 * 页面跳转测试controller
 */
@Controller
@CrossOrigin(origins = "*")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/httpGet")
    public String httpGet(){
        return null;
    }

    @RequestMapping("/httpPost")
    public String httpPost(){
        return null;
    }
}

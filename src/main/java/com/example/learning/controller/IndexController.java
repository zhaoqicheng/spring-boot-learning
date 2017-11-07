package com.example.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaoqicheng on 2017/5/25.
 *
 * 页面跳转测试controller
 */
@Controller
@CrossOrigin(origins = "*")
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}

package com.example.learning.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhaoqicheng on 2017/5/9.
 */
@CrossOrigin(origins = "*")
public class BaseController {

    /**
     * 处理前台传入日期无法封装到实体类发生类型转换错误异常
     *
     * @param request
     * @param binder
     * @throws Exception
     */
    @InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm"), true));
    }
}

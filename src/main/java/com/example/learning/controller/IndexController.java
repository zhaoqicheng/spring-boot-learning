package com.example.learning.controller;

import org.bouncycastle.asn1.ua.DSTU4145NamedCurves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoqicheng on 2017/5/25.
 * <p>
 * 页面跳转测试controller
 * <p>
 * 测试RestTemplate的请求
 * <p>
 * <p>
 * restTemplate.exchange(
 * String url,
 * HttpMethod method,
 * HttpEntity requestEntity,
 * Class responseType,
 * Object uriVariables[]
 * )
 * <p>
 * 说明：
 * 1）url: 请求地址；
 * 2）method: 请求类型(如：POST,PUT,DELETE,GET)；
 * 3）requestEntity: 请求实体，封装请求头，请求内容
 * 4）responseType: 响应类型，根据服务接口的返回类型决定
 * 5）uriVariables: url中参数变量值
 */
@Controller
@CrossOrigin(origins = "*")
public class IndexController {

    private String DIC_DATA_URL = "http://www.baidu.com/";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/httpGet")
    public String httpGet() {
        ResponseEntity<Map> resp = restTemplate.exchange(DIC_DATA_URL + "?id={id}", HttpMethod.DELETE, null, Map.class, 227);
        return null;
    }

    @RequestMapping("/httpPost")
    public String httpPost() {
        String reqJsonStr = "{\"code\":\"testCode\", \"group\":\"testGroup\",\"content\":\"testContent\", \"order\":1}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(reqJsonStr, headers);
        ResponseEntity<Map> resp = restTemplate.exchange(DIC_DATA_URL, HttpMethod.POST, entity, Map.class);
        return null;
    }

    @RequestMapping("/httpPut")
    public String httpPut() {
        String reqJsonStr = "{\"id\":227,\"code\":\"updateCC\", \"group\":\"UPDATE\",\"content\":\"updateCT\", \"order\":9}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(reqJsonStr, headers);
        ResponseEntity<Map> resp = restTemplate.exchange(DIC_DATA_URL, HttpMethod.PUT, entity, Map.class);
        return null;
    }

    @RequestMapping("/httpDelete")
    public String httpDelete() {
        HashMap<Object, Object> params = new HashMap<>();
        ResponseEntity<String> results = restTemplate.exchange(DIC_DATA_URL, HttpMethod.GET, null, String.class, DSTU4145NamedCurves.params);
        return null;
    }


}

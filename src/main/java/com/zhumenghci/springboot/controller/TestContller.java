package com.zhumenghci.springboot.controller;

import com.zhumenghci.springboot.config.WXConfig;
import com.zhumenghci.springboot.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/test")
@PropertySource("classpath:pay.properties")
public class TestContller implements Serializable {

    @Value("${wxpay.appid}")
    private String payAppid;

    @Value("${wxpay.sercret}")
    private String paySecret;

    @GetMapping("list")
    public JsonData testExt(){

        int i =  1/0;

        return JsonData.buildSuccess("");
    }

    @Autowired
    private WXConfig wxConfig;

    @GetMapping("get_config")
    public JsonData testConfig(){

        Map<String,String> map = new HashMap<>();
//        map.put("appid",payAppid);
//        map.put("secret",paySecret);
//
//        return JsonData.buildSuccess(map);

        map.put("appid",wxConfig.getPayAppid());

        return JsonData.buildSuccess(map);
    }

}

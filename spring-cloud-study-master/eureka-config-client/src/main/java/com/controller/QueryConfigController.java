package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class QueryConfigController {

    @Value("${sb.name}")
    private String message;

    @RequestMapping("/message")
    public String message() {
        System.out.println("从配置服务器拉取配置信息：" + message);
        return message;
    }

}

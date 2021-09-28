package com.eureka.provider.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

@RestController
public class ProviderController {

    @RequestMapping("/sellProduct")
    public String sellProduct(String productName) throws Exception{
        if (StringUtils.isEmpty(productName)){
            throw new Exception("productName不能为空!");
        }
        return "出售["+ productName +"]一份!";
    }

}

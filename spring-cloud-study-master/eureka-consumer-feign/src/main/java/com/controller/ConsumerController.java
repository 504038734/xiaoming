package com.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.service.FeignService;
import com.service.FeignServiceNew;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * feign controller
 */
@RestController
public class ConsumerController {

    @Resource
    private FeignService feignService;
    @Resource
    private FeignServiceNew feignServiceNew;


    /**
     * controller中方法如果加了熔断,会优先走该返回
     * 例如 provider中提供的服务挂了, feignService中已经进行了熔断,理论上应该是返回feignService熔断方法的内容,实际上并没有!!!
     * @param productName
     * @return
     * @throws Exception
     */
    @RequestMapping("/buyProduct")
//    @HystrixCommand(fallbackMethod = "businessError")
    public String sellProduct(@RequestParam(value = "productName") String productName)throws Exception{
        if ("狗屎".equals(productName)){
            throw new Exception("暂不支持的类型!");
        }
        return feignService.sellProduct(productName);
    }

    @RequestMapping("/buyProductNew")
//    @HystrixCommand(fallbackMethod = "businessError")
    public String sellProductNew(String productName)throws Exception{
        if ("猪食".equals(productName)){
            throw new Exception("暂不支持的类型!");
        }
        return feignServiceNew.sellProduct(productName);
    }


    public String businessError(String productName)throws Exception{
        return "对不起,没有这个东东["+productName+"]!";
    }

}

package com.zyl.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description 订单服务controller
 * @create 2021-04-15 21:38
 **/
@RestController
public class OrderZkController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/zk")
    public String paymentInfo () {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }
}

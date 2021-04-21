package com.zyl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description 支付微服务启动类8004
 * EnableDiscoveryClient: 向consul或者zookeeper作为注册中心时注册服务
 * @create 2021-04-14 22:43
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}

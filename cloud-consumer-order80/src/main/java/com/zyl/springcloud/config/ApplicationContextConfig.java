package com.zyl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description 应用的配置类
 * @create 2020-08-27 21:10
 **/
@Configuration
public class ApplicationContextConfig {

    /**
     * @LoadBalanced 该注解主要是开启restTemplate的负载均衡功能
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

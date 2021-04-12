package com.zyl.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description Hello服务
 * @create 2020-09-28 17:32
 **/
@Service
public class HelloService {
    private final RestTemplate restTemplate;

    @Autowired
    public HelloService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * HystrixCommand 注解当服务不可访达时，起到熔断器的作用。
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(Long id) {
        return restTemplate.getForObject("http://CLOUD-PAYMENT-SERVICE/payment/" + id, String.class);
    }

    /**
     * 当服务不可访达时，会调用该方法
     * @param id
     * @return
     */
    public String hiError(Long id) {
        return "hi," + id + ",sorry,error!";
    }
}

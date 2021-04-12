package com.zyl.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description springcloud config client启动类
 * @create 2020-10-13 13:44
 **/
@SpringBootApplication
@RestController
public class ConfigClientApplication{
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "hi")
    public String hi() {
        return foo;
    }
}


package com.zyl.springcloud.controller;

import com.zyl.springcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description Hello 控制层
 * @create 2020-09-28 17:51
 **/
@RestController
public class HelloController {
    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/payment/{id}")
    public String hi(@PathVariable("id") Long id) {
        return helloService.hiService(id);
    }
}

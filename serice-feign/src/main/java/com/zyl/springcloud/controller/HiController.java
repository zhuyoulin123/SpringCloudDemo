package com.zyl.springcloud.controller;

import com.zyl.springcloud.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description hi controller
 * @create 2020-09-29 10:21
 **/
@RestController
public class HiController {
    private final SchedualServiceHi schedualServiceHi;

    @Autowired
    public HiController(SchedualServiceHi schedualServiceHi) {
        this.schedualServiceHi = schedualServiceHi;
    }

    @GetMapping("/payment/{id}")
    public String sayHi(@PathVariable("id") Long id) {
        return schedualServiceHi.sayHiFromClientOne(id);
    }
}

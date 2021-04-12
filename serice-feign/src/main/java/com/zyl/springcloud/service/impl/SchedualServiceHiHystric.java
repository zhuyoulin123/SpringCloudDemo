package com.zyl.springcloud.service.impl;

import com.zyl.springcloud.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description hystric实现类, 实现对应方法，从而实现在feign中集成hystric
 * @create 2020-09-29 15:07
 **/
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(Long id) {
        return "sorry" + id;
    }
}

package com.zyl.springcloud.service;

import com.zyl.springcloud.service.impl.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description say hi service
 * @create 2020-09-29 09:59
 **/
@FeignClient(value = "CLOUD-PAYMENT-SERVICE", fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
    /**
     * say hi
     * @param id
     * @return request json
     */
    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    String sayHiFromClientOne(@PathVariable(value = "id")Long id);
}

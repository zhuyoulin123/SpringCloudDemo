package com.zyl.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description ribbon 自定义规则
 * @create 2021-04-20 22:45
 **/
@Configuration
public class MyselfRule {
    @Bean
    public IRule MyRule () {
        // 定义为随机
        return new RetryRule();
    }
}

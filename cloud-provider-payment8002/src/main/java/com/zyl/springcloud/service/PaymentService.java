package com.zyl.springcloud.service;

import com.zyl.springcloud.entities.Payment;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description Payment服务
 * @create 2020-08-26 20:41
 **/
public interface PaymentService {
    /**
     * 新增
     * @param payment 实体
     * @return 新增payment实体类的主键ID
     */
    Long create(Payment payment);

    /**
     * 根据主键ID获取对应的订单
     * @param id 主键ID
     * @return 订单实体类
     */
    Payment getPaymentById(Long id);
}

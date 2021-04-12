package com.zyl.springcloud.dao;

import com.zyl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description 订单表DAO
 * @create 2020-08-26 18:25
 **/
@Mapper
public interface PaymentDao {
    /**
     * 新增
     * @param payment 实体
     * @return 新增结果
     */
    int create(Payment payment);

    /**
     * 根据主键ID获取对应的订单
     * @param id 主键ID
     * @return 订单实体类
     */
    Payment getPaymentById(@Param("id") Long id);
}

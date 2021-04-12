package com.zyl.springcloud.service.impl;

import com.zyl.springcloud.dao.PaymentDao;
import com.zyl.springcloud.entities.Payment;
import com.zyl.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description Payment服务实现
 * @create 2020-08-26 20:42
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDao paymentDao;
    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Long create(Payment payment) {
        paymentDao.create(payment);
        return payment.getId();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

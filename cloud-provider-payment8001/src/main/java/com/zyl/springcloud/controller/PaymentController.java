package com.zyl.springcloud.controller;

import com.zyl.springcloud.entities.CommonResult;
import com.zyl.springcloud.entities.Payment;
import com.zyl.springcloud.service.PaymentService;
import com.zyl.springcloud.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description Payment控制层
 * @create 2020-08-26 20:44
 **/
@RestController
public class PaymentController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    private final PaymentService paymentService;
    /**
     * 为了测试负载是否生效使用
     */
    @Value("${server.port}")
    private String port;
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("payment")
    public CommonResult create (@RequestBody Payment payment) {
        try {
            if (payment == null && StrUtil.isNull(payment.getSerial())) {
                return new CommonResult(20001, "empty params");
            }
            Long result = paymentService.create(payment);

            if (result != null && result > 0) {
                return new CommonResult(20000, "success,port:" + port, result);
            } else {
                logger.error("Payment{}新增失败", Payment.class);
                return new CommonResult(20002, "create fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            return new CommonResult(50000, "service error");
        }
    }

    @GetMapping("payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        try {
            if (id == null) {
                return new CommonResult(20001, "empty params");
            }
            Payment result = paymentService.getPaymentById(id);

            if (result != null) {
                return new CommonResult(20000, "success,port:" + port, result);
            } else {
                logger.error("Payment主键ID{}未找到对应数据", id);
                return new CommonResult(20002, "query empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            return new CommonResult(50000, "service error");
        }
    }
}

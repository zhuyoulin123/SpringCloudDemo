package com.zyl.springcloud.controller;

import com.zyl.springcloud.entities.CommonResult;
import com.zyl.springcloud.entities.Payment;
import com.zyl.springcloud.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description 订单控制层
 * @create 2020-08-27 21:08
 **/
@RestController
public class OrderController {
    // private static final String PAYMENT_URL = "http://127.0.0.1:8001/";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";
    private final RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("consumer/payment")
    public CommonResult create (Payment payment) {
        try {
            if (payment == null && StrUtil.isNull(payment.getSerial())) {
                return new CommonResult(20001, "empty params");
            }
            return restTemplate.postForObject(PAYMENT_URL + "payment", payment, CommonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            return new CommonResult(50000, "service error");
        }
    }

    @GetMapping("consumer/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        try {
            if (id == null) {
                return new CommonResult(20001, "empty params");
            }
            return restTemplate.getForObject(PAYMENT_URL + "payment/" + id, CommonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            return new CommonResult(50000, "service error");
        }
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id")Long id) {
        ResponseEntity<CommonResult> entity = restTemplate
                .getForEntity(PAYMENT_URL + "/payment/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(entity.getStatusCodeValue(), "操作失败");
        }
    }
}

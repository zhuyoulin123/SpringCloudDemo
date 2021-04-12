package com.zyl.springcloud.entities;

import java.io.Serializable;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description Payment实体类
 * @create 2020-08-26 18:08
 **/
public class Payment implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 订单流水号
     */
    private String serial;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}

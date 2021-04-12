package com.zyl.springcloud.entities;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description 通用的返回给前端的实体
 * @create 2020-08-26 18:19
 **/
public class CommonResult<T> {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 信息
     */
    private String message;
    /**
     * 需要返回的实体类
     */
    private T      data;

    public CommonResult() {

    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(Integer code, String message, T o) {
        this.code = code;
        this.message = message;
        this.data = o;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

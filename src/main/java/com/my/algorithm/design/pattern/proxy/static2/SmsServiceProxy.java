package com.my.algorithm.design.pattern.proxy.static2;

import com.my.algorithm.design.pattern.proxy.dynamic.SmsService;
import com.my.algorithm.design.pattern.proxy.dynamic.SmsServiceImpl;

public class SmsServiceProxy implements SmsService {

    private final SmsService smsService;

    /**
     * 代理类中注入目标对象
     *
     * @param smsService
     */
    public SmsServiceProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    /**
     * 调用目标类中的对应的方法
     *
     * @param message
     * @return
     */
    @Override
    public String send(String message) {
        System.out.println("before send");
        smsService.send(message);
        System.out.println("after send");
        return null;
    }

    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsServiceProxy smsServiceProxy = new SmsServiceProxy(smsService);
        smsServiceProxy.send("静态代理");
    }
}
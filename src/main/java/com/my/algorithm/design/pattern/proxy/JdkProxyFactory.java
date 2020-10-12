package com.my.algorithm.design.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * Discription:
 * Created by guokun on 2020/10/10.
 */
public class JdkProxyFactory {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MessageInvocationHandler(target));
    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("jdk动态代理");
    }


}

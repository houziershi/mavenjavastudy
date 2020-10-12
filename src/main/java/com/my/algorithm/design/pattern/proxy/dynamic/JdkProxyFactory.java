package com.my.algorithm.design.pattern.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * Discription:
 * Created by guokun on 2020/10/10.
 */
public class JdkProxyFactory {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new MessageInvocationHandler(target));
    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("jdk动态代理");

//        // 新建业务逻辑
//        OrderService orderService = new OrderServiceImpl();
//        ProductService productService = new ProductServiceImpl();
//        // 新建我们的 日志 Handler
//        LoggerInterceptor loggerInterceptor = new LoggerInterceptor();
//
//        //绑定 委托类同时生产代理类调用 。
//        OrderService orderServiceProxy = (OrderService) loggerInterceptor.bind(orderService);
//        orderServiceProxy.createOder("12927381");
//
//        ProductService productServiceProxy = (ProductService) loggerInterceptor.bind(productService);
//        productServiceProxy.getProduct("34010234");

    }

}

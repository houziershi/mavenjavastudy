package com.my.algorithm.design.pattern.proxy.dynamic;

public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message: " + message);
        return message;
    }


}
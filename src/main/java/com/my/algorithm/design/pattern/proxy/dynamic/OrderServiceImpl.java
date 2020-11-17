package com.my.algorithm.design.pattern.proxy.dynamic;

public class OrderServiceImpl implements OrderService {
    @Override
    public String createOder(String no) {
        return "生成订单" + no + "成功";
    }
}
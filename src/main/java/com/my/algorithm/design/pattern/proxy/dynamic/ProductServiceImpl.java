package com.my.algorithm.design.pattern.proxy.dynamic;

public class ProductServiceImpl implements ProductService {
    @Override
    public String getProduct(String no) {
        return "获取商品" + no + "成功";
    }
}
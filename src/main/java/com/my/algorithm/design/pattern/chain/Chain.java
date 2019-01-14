package com.my.algorithm.design.pattern.chain;

/**
 * Created by guokun on 2018/8/16.
 * Description:责任链模式
 * @param
 * @return
 */
public interface Chain {
    void setNext(Chain chain);
    void process(Number number);
}
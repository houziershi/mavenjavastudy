package com.my.concurrent.model;

public interface Producer {
    void produce() throws InterruptedException;
}
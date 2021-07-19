package com.my.concurrent.model;

public interface Consumer {
    void consume() throws InterruptedException;
}
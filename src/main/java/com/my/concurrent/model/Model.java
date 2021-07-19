package com.my.concurrent.model;

public interface Model {
    Runnable newRunnableConsumer();

    Runnable newRunnableProducer();
}
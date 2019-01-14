package com.my.algorithm.design.pattern.singleton;

public class MySingleton {
    private static MySingleton ourInstance = new MySingleton();

    public static MySingleton getInstance() {
        return ourInstance;
    }

    private MySingleton() {
    }
}

package com.my.algorithm.design.pattern.singleton;

public class MySingleton {

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final MySingleton INSTANCE = new MySingleton();
    }
}

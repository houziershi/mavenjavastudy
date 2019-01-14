package com.my.algorithm.design.pattern.intercept;

import java.io.IOException;

public interface Interceptor {

    MyResponse intercept(Chain chain) throws IOException;

    interface Chain {
        MyRequest request();

        MyResponse proceed(MyRequest request) throws IOException;
    }
}

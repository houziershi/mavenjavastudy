package com.my.algorithm.design.pattern.intercept;
/**
 * Created by guokun on 2018/12/4.
 * Description: 模仿OkHttp Interceptor 责任链设计模式
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class MyInterceptorChain implements Interceptor.Chain {
    private final List<Interceptor> interceptors;
    private final MyRequest myRequest;
    //    private int calls;
    private int index;

    public MyInterceptorChain(List<Interceptor> interceptors, int index, MyRequest myRequest) {
        this.interceptors = interceptors;
        this.index = index;
        this.myRequest = myRequest;
    }

    public static void main(String[] args) {

        OneInterceptor oneInterceptor = new OneInterceptor("one_Request", "one_response");
        TwoInterceptor twoInterceptor = new TwoInterceptor("two_request", "two_response");
        ThreeInterceptor threeInterceptor = new ThreeInterceptor("three_request", " three_response");
        final List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(oneInterceptor);
        interceptors.add(twoInterceptor);
        interceptors.add(threeInterceptor);

        final MyRequest mainRequest = new MyRequest("main ");
        MyInterceptorChain myInterceptorChain = new MyInterceptorChain(interceptors, 0, mainRequest);
        try {
            System.out.println(myInterceptorChain.proceed(mainRequest).getResponseDiscription());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public MyRequest request() {
        return myRequest;
    }

    @Override
    public MyResponse proceed(MyRequest request) throws IOException {
        if (index >= interceptors.size()) throw new AssertionError();
//        calls++;

        MyInterceptorChain next = new MyInterceptorChain(interceptors, index + 1, request);
        Interceptor interceptor = interceptors.get(index);
        MyResponse response = interceptor.intercept(next);

        return response;
    }
}

package com.my.algorithm.design.pattern.intercept;

import java.io.IOException;

public final class TwoInterceptor implements Interceptor {
    private String twoRequest;
    private String twoResponse;

    public TwoInterceptor(String oneRequest, String oneResponse) {
        this.twoRequest = oneRequest;
        this.twoResponse = oneResponse;
    }

    @Override
    public MyResponse intercept(Chain chain) throws IOException {
        MyRequest myRequest = chain.request();
        myRequest.setRequestdiscription(twoRequest);
        System.out.println("two interceptor-----------request======="+myRequest.getRequestdiscription());

        MyResponse myResponse = chain.proceed(myRequest);
//        MyResponse myResponse = testFor(null, chain);
        System.out.println("two interceptor---------response==="+myResponse.getResponseDiscription());
        return myResponse;
    }

    private MyResponse testFor(MyResponse myResponse, Chain chain) throws IOException {
        MyRequest myRequest = chain.request();
        MyResponse response = null;
        for (int i=0;i<2;i++) {
            MyRequest myRequest1 = new MyRequest(myRequest+"----"+i+"    "+myRequest.getRequestdiscription());
            response = chain.proceed(myRequest1);
        }

        return response;
    }
}

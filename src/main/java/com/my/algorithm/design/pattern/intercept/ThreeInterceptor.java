package com.my.algorithm.design.pattern.intercept;

import java.io.IOException;

public final class ThreeInterceptor implements Interceptor {
    private String threeRequest;
    private String threeResponse;

    public ThreeInterceptor(String oneRequest, String oneResponse) {
        this.threeRequest = oneRequest;
        this.threeResponse = oneResponse;
    }

    @Override
    public MyResponse intercept(Chain chain) throws IOException {
        MyRequest myRequest = chain.request();
        myRequest.setRequestdiscription(threeRequest);
        System.out.println("three interceptor ------------request====="+myRequest.getRequestdiscription());

        MyResponse myResponse = new MyResponse("threeResponse ");
        System.out.println("three interceptor ------------response ======"+myResponse.getResponseDiscription());
        return myResponse;
    }
}

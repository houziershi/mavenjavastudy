package com.my.algorithm.design.pattern.intercept;

import java.io.IOException;

public final class OneInterceptor implements Interceptor {
    private String oneRequest;
    private String oneResponse;

    public OneInterceptor(String oneRequest, String oneResponse) {
        this.oneRequest = oneRequest;
        this.oneResponse = oneResponse;
    }

    @Override
    public MyResponse intercept(Chain chain) throws IOException {
        MyRequest myRequest = chain.request();
        myRequest.setRequestdiscription(oneRequest);
        System.out.println("one interceptor --------------request===="+myRequest.getRequestdiscription());

        MyResponse myResponse = chain.proceed(myRequest);
        myResponse.setResponseDiscription(oneResponse);
        System.out.println("one interceptor -----------------response======="+myResponse.getResponseDiscription());
        return myResponse;
    }
}

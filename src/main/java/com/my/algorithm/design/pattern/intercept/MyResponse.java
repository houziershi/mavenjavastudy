package com.my.algorithm.design.pattern.intercept;

public class MyResponse {
    private String responseDiscription;

    public MyResponse() {
        System.out.println("response construct enter");
    }

    public MyResponse(String discription) {
        this.responseDiscription = discription;
    }

    public String getResponseDiscription() {
        return responseDiscription;
    }

    public void setResponseDiscription(String responseDis) {
        this.responseDiscription = this.responseDiscription +"  "+ responseDis;
    }
}

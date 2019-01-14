package com.my.algorithm.design.pattern.intercept;

public class MyRequest {
    private String requestdiscription;

    public MyRequest() {
        System.out.println("request construct enter");
    }

    public MyRequest(String discription) {
        this.requestdiscription = discription;
    }

    public String getRequestdiscription() {
        return requestdiscription;
    }

    public void setRequestdiscription(String requestdis) {
        this.requestdiscription = this.requestdiscription +"   " +requestdis;
    }
}

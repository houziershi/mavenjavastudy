package com.guokun.http;

public class ProxyMain {
    public static void main(String[] args) {
        String password = "33805E75F6BA45F1";
        String userName = "3000005507";
        String proxyHost = "lrts.gzproxy.10155.com";
        int proxyPort = 1082;
        HttpProxyClient proxyClient = new HttpProxyClient(userName, password, proxyHost, proxyPort);

        // 发送请求 测试
        String targetUrl = "https://bookpic.lrts.me/e921b37d1ecf44928351cb0254660711.png";
        int statusCode = proxyClient.requestTargetUrl(targetUrl);
        System.out.println("request status code is : " + statusCode);
    }
}

package com.guokun.http;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthPolicy;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chengnp on 16-8-9.
 */
public class HttpProxyClient {

    /**
     * 代理服务器验证密码
     */
    private String password;

    /**
     *  代理服务器验证用户名
     */
    private String userName;

    /**
     * 代理服务器地址
     * 案例: 157.255.23.14
     */
    private String proxyHost;

    /**
     * 代理服务器端口号
     * 案例: 80
     */
    private int proxyPort;

    /**
     * 构造对象HttpPrxoyClient.
     *
     * @param userName 代理服务器验证用户名
     * @param password 代理服务器验证密码
     * @param proxyHost 代理服务器地址
     * @param proxyPort 代理服务器端口号
     */
    public HttpProxyClient(String userName, String password, String proxyHost, int proxyPort) {
        this.userName = userName;
        this.password = password;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }

    private HttpClient getHttpClient(){
        HttpClient httpClient = new HttpClient();

        httpClient.getHostConfiguration().setProxy(proxyHost, proxyPort);

        //需要验证
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials(userName, password);

        httpClient.getState().setProxyCredentials(AuthScope.ANY, creds);
        httpClient.getState().setCredentials(AuthScope.ANY, creds);
        List authPrefs = new ArrayList(1);
        authPrefs.add(AuthPolicy.DIGEST);
        httpClient.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);
        return httpClient;
    }

    /**
     * 通过代理服务器发送请求到目标地址.
     * @param targetUrl 目标地址
     * @return 返回结果状态码.
     */
    public int requestTargetUrl(String targetUrl) {
        int statusCode = -1;
        HttpClient httpClient = getHttpClient();
        GetMethod method = new GetMethod(targetUrl);
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));
        try {
            statusCode = httpClient.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("Method failed code=" + statusCode + ": " + method.getStatusLine());
            }  else {
                System.out.println(new String(method.getResponseBody(), "gb2312"));
            }
        } catch(Exception e ){
            e.printStackTrace();
        }finally {
            method.releaseConnection();
        }
        return statusCode;
    }
}
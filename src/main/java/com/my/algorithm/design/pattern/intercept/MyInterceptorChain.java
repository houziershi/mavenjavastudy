package com.my.algorithm.design.pattern.intercept;
/**
 * Created by guokun on 2018/12/4.
 * Description: 模仿OkHttp Interceptor 责任链设计模式
 */

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

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

        MyClass myClass = new MyClass();

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());

        executorService.execute(() -> {
            try {
                myClass.myThrowMethod();
            } catch (Exception e) {
                System.out.println("my exception====方法1======" + e);
            }
        });
        executorService.shutdown();

        /*
        try {
            executorService.execute(() -> myClass.myThrowMethod());
        } catch (Exception e) {
            System.out.println("my exception====方法2======" + e);
        }
        executorService.shutdown();

        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myClass.myThrowMethod();
                }
            }).start();
        } catch (Exception e) {
            System.out.println("my exception====方法3======" + e);
        }*/

        /*Future<String> future =  executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                myClass.myThrowMethod();
                return "success";
            }
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/


//        testThrowMethod();
        System.out.println("main enter");
//        executorService.shutdown();
        /*OneInterceptor oneInterceptor = new OneInterceptor("one Request", "one response");
        TwoInterceptor twoInterceptor = new TwoInterceptor("two request", "two response");
        ThreeInterceptor threeInterceptor = new ThreeInterceptor("three request", " three response");
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
        }*/
    }

    public static void testThrowMethod() {
        throw new NullPointerException();
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

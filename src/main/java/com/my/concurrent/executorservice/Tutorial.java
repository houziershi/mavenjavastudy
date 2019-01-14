package com.my.concurrent.executorservice;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by guokun on 2018/12/14.
 * Description: executorservice 使用范例
 */
public class Tutorial {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Created by guokun on 2018/12/14.
     * Description: 不要显示的创建线程，请使用线程池
     */
    public static void singleThread(Runnable runnable) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS
                , new LinkedBlockingDeque<Runnable>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(runnable);
        executorService.shutdown();
    }

    /**
     * Created by guokun on 2018/12/19.
     * Description:多线程并行处理定时任务时，Timer运行多个TimeTask时，只要其中之一没有捕获抛出的异常，
     * 其它任务便会自动终止运行，使用ScheduledExecutorService则没有这个问题。
     *
     * @param
     * @return
     */
    public static void createTimer(Runnable runnable, long initialDelay, long period) {
        /*ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());*/
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.scheduleAtFixedRate(runnable, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {

        singleThread(() ->
                System.out.println("single thread========" + Thread.currentThread().getName()));


        createTimer(() ->
                        System.out.println("timer thread ========" + Thread.currentThread().getName() + "" +
                                "time ========" + format.format(new Date()))
                , 1000, 5000);
    }
}

package com.my.concurrent.executorservice;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
//        executorService.shutdown();
    }

    public static void main(String[] args) {

        singleThread(() ->
                System.out.println("single thread========" + Thread.currentThread().getName()));


        createTimer(() ->
                        System.out.println("timer thread ========" + Thread.currentThread().getName() + "" +
                                "time ========" + format.format(new Date()))
                , 1000, 5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> System.out.println("newCachedThreadPool thread========" + Thread.currentThread().getName()));
        }
        executorService.shutdown();

//        testHashMap();
    }

    public static void testHashMap() {
        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("唐僧","pwd1",25);
        Person p2 = new Person("孙悟空","pwd2",26);
        Person p3 = new Person("猪八戒","pwd3",27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!
        p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变。ps：必须重写hashcode方法和equals方法

        set.remove(p3); //此时remove不掉，造成内存泄漏

        set.add(p3); //重新添加，居然添加成功
        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:4 个元素!
        for (Person person : set)
        {
            System.out.println(person);
        }
    }
}


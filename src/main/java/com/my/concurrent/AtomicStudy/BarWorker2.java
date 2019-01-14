package com.my.concurrent.AtomicStudy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class BarWorker2 implements Runnable {

    private static AtomicBoolean exists = new AtomicBoolean(false);
    private String name;

    public BarWorker2(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        BarWorker2 bar1 = new BarWorker2("bar1");
        BarWorker2 bar2 = new BarWorker2("bar2");
        new Thread(bar1).start();
        new Thread(bar2).start();

        try {
            System.out.println("---------- working");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            // do nothing
        }
        BarWorker2 bar3 = new BarWorker2("bar3");
        new Thread(bar3).start();
    }

    @Override
    public void run() {
        System.out.println("run() method enter "+exists);

        //读-改-写为原子操作
        if (exists.compareAndSet(false, true)) {
            System.out.println(name + "-------- enter");
            try {
                System.out.println(name + "---------- working");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // do nothing
            }
            System.out.println(name + "--------- leave");
            exists.set(false);
        } else {
            System.out.println(name + "---------- give up");
        }
    }
}


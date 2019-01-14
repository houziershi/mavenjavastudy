package com.my.concurrent.AtomicStudy;

import java.util.concurrent.TimeUnit;

public class BarWorker implements Runnable{
    private static boolean exits = false;
    private String name;

    public BarWorker(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        BarWorker barWorker1 = new BarWorker("bar work one");
        BarWorker barWorker2 = new BarWorker("bar work two");

        new Thread(barWorker1).start();
        new Thread(barWorker2).start();
    }

    @Override
    public void run() {
        System.out.println("run() enter --------exits ==="+ exits);
        if (!exits) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // TODO: do something
                e.printStackTrace();
            }

            exits = true;
            System.out.println(name + " -------------enter");

            try {
                System.out.println(name + " --------working ");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " -----------leave");
            exits = false;
        } else {
            System.out.println(name + " ------ give up");
        }
    }
}

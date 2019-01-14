package com.my.concurrent.SynchronizedStudy;

import java.util.concurrent.TimeUnit;

public class MySynchronized {
    private int id;

    public synchronized int getId() {
        /*try {
            System.out.println("---getId()------- working");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            // do nothing
        }*/
        return id;
    }

    public synchronized void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        MySynchronized mySynchronized = new MySynchronized();
        mySynchronized.setId(123);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" ----------- " + mySynchronized.getId());
                mySynchronized.setId(100);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" ----------- " + mySynchronized.getId());
            }
        }).start();
    }
}

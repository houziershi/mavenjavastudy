package com.my.base.threadLocaltip;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestFive {
    final PipedInputStream pis = new PipedInputStream();
    final PipedOutputStream pos = new PipedOutputStream();

    public static void main(String[] args) {
        TestFive t = new TestFive();
        new Thread(t.new Producer()).start();
        new Thread(t.new Consumer()).start();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            try {
                pis.connect(pos);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                while (true) { //不断的产生数据
                    int n = (int) (Math.random() * 255);
                    System.out.println(Thread.currentThread().getName() + "produce::" + n);
                    pos.write(n);
                    pos.flush();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    pis.close();
                    pos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            int n;
            try {
                while (true) {
                    n = pis.read();
                    System.out.println(Thread.currentThread().getName() + "consume::" + n);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    pis.close();
                    pos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }
}


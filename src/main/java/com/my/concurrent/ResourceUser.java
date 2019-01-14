package com.my.concurrent;

public class ResourceUser implements Runnable {
    private ResourceManage resourceManage;
    private int userId;

    public ResourceUser(ResourceManage resourceManage, int userId) {
        this.resourceManage = resourceManage;
        this.userId = userId;
    }

    public void run() {
        System.out.print("userId:" + userId + "准备使用资源...\n");
        resourceManage.useResource(userId);
        System.out.print("userId:" + userId + "使用资源完毕...\n");
    }

    public static void main(String[] args) {
        ResourceManage resourceManage = new ResourceManage();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new ResourceUser(resourceManage, i));//创建多个资源使用者
            threads[i] = thread;
        }
        for (int i = 0; i < 100; i++) {
            Thread thread = threads[i];
            try {
                thread.start();//启动线程
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

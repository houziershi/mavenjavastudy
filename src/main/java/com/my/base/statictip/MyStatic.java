package com.my.base.statictip;

/**
 * @Description: 静态变量的初始化顺序
 * @author: guokun
 * @data: 2018/8/29
 */
public class MyStatic {
    static {
        System.out.println("哥不在了");
    }

    private static MyStatic myStatic = new MyStatic();

    private MyStatic() {
        System.out.println("哥初始化了");
    }

    {
        System.out.println("哥随便溜溜");
    }

    static {
        System.out.println("哥又回来了");
    }

    public static MyStatic getInstance() {
        return myStatic;
    }

    public static void main(String[] args) {

    }
}

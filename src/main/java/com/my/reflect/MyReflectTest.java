package com.my.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Discription:
 * Created by guokun on 2018/8/16.
 */
public class MyReflectTest {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(null);
        Integer integer = integers.get(0);
        System.out.println(integer);

        MyReflect myReflect = new MyReflect();
        Class<?> myClass = myReflect.getClass();
        try {
            Method setParameter = myClass.getDeclaredMethod("setParameter", int.class);
            setParameter.setAccessible(true);
            setParameter.invoke(myReflect, 12);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Field parameter = myClass.getDeclaredField("parameter");
            parameter.setAccessible(true);
            System.out.println("Field parameter ==" + parameter.getInt(myReflect));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Method setParameter = myClass.getDeclaredMethod("getParameter");
            setParameter.setAccessible(true);
            System.out.println("getParameter  parameter ==" + setParameter.invoke(myReflect));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("0.1+0.2==============" + (0.1 + 0.2));
    }
}

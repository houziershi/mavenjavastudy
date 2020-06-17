package com.my.reflect;

import com.google.common.base.Objects;

/**
 * Discription:
 * Created by guokun on 2018/8/16.
 */
public class MyReflect {
    private int parameter;

    public MyReflect() {
    }

    public MyReflect(int parameter) {
        this.parameter = parameter;
    }

    private int getParameter() {
        return parameter;
    }
    private void setParameter(int parameter) {
        this.parameter = parameter;
    }

}

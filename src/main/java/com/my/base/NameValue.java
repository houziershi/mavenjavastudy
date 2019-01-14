package com.my.base;

public class NameValue implements Comparable<NameValue> {
    private String name;
    private float tag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTag() {
        return tag;
    }

    public void setTag(float tag) {
        this.tag = tag;
    }

    @Override
    public int compareTo(NameValue o) {
        float x = this.tag;
        float y = o.tag;

        return x < y ? -1 : (x == y) ? 0 : 1;
    }

    @Override
    public String toString() {
        return name + "=" + tag;
    }
}

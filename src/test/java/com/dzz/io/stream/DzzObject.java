package com.dzz.io.stream;

import java.io.Serializable;

/**
 * create by zoufeng on 2018/7/20
 */
public class DzzObject implements Serializable {

    private static final long serialVersionUID = -548199098184506173L;

    private String name;

    //新增
    private int age;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public DzzObject setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public DzzObject setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return getName() == null ? "no name" : getName();
    }
}

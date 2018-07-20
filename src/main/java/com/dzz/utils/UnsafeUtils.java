package com.dzz.utils;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * create by zoufeng on 2018/7/19
 */
public class UnsafeUtils {

    public static Unsafe getUnsafeInstance() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }
}

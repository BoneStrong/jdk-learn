package com.dzz.nio;

import java.nio.ByteBuffer;

/**
 * create by zoufeng on 2018/7/20
 */
public class ByteBufferDemo {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        String value = "hehe";
        buffer.put(value.getBytes());
        buffer.flip();//读写切换
        byte[] vArray = new byte[buffer.remaining()];//获取可读取的字节长度
        buffer.get(vArray);//读取缓存字节数组
        System.out.println(new String(vArray));
    }
}

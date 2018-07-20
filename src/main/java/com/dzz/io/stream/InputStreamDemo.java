package com.dzz.io.stream;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * create by zoufeng on 2018/7/14
 */
public class InputStreamDemo {

    private volatile byte[] buff;

    public static final AtomicReferenceFieldUpdater<InputStreamDemo, byte[]> UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(InputStreamDemo.class, byte[].class, "buff");

    public void fill() {

    }

    public void close() throws InterruptedException {
        byte[] bytes = buff;
        System.out.println("睡之前" + bytes);
        Thread.sleep(4000);
        System.out.println("睡之后" + bytes);

//        UPDATER.compareAndSet(this, buff, null);
    }

    public byte[] getBuff() {
        return buff;
    }

    public InputStreamDemo setBuff(byte[] buff) {
        this.buff = buff;
        return this;
    }

    public static void main(String[] args) throws InterruptedException {
        InputStreamDemo demo = new InputStreamDemo().setBuff(new byte[1]);
        new Thread(() -> {
            boolean b = UPDATER.compareAndSet(demo, demo.getBuff(), null);
            System.out.println(b);
            System.out.println(demo.getBuff());
        }).start();
        demo.close();
        Thread.sleep(5000);

    }
}

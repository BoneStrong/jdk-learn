package com.dzz.io.stream;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * create by zoufeng on 2018/7/20
 */
public class ObjectStreanTest {

    DzzObject dzzObject = new DzzObject().setName("dzz");

    @Test
    public void input() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\temp\\dzzObject.txt"));
        Object o = in.readObject();
        System.out.println(o);
    }

    @Test
    public void output() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\temp\\dzzObject.txt"));
        out.writeObject(dzzObject);
    }
}

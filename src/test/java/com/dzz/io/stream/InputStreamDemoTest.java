package com.dzz.io.stream;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * create by zoufeng on 2018/7/14
 * <p>
 * try( resource ){}catch(){}
 */
public class InputStreamDemoTest {

    /**
     * 两次调用发现流的顺序是连续的，说明流不能重复读取，内部维护了一个offset
     */
    @Test
    public void test() {
        FileInputStream in = null;
        try {
            in = new FileInputStream("D:\\temp\\h2.txt");
            byte[] bytes = readLen(in, 20);
            System.out.println(bytes.length);
            System.out.println(new String(bytes, "utf-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            byte[] bytes = readLen(in, 20);
            System.out.println(bytes.length);
            System.out.println(new String(bytes, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] readLen(InputStream in, int len) throws IOException {
        int c = 0;
        byte[] bytes = new byte[len];
        int size = 0;
        while ((c = in.read()) != -1 && size < len) {
            bytes[size] = (byte) c;
            size++;
        }
        System.out.println("size = " + size);
        if (size < len - 1) {
            bytes = Arrays.copyOf(bytes, size + 1);
        }
        return bytes;
    }

    @Test
    public void intAarry() {
        int[] ints = new int[]{0, 1, 2, 3, 4, 5};
        int i = 0;
        System.out.println(ints[i++]);
        System.out.println(ints[i]);
        System.out.println(ints[++i]);
    }


    class HeheOutputStream extends ByteArrayOutputStream {

        public HeheOutputStream(int size) {
            super(size);
        }

        @Override
        public void flush() throws IOException {
            System.out.println("hehe flush!");
            super.flush();
        }

        @Override
        public void close() throws IOException {
            System.out.println("hehe close!");
            super.close();
        }
    }

    @Test
    public void close() {
        try (HeheOutputStream outputStream = new HeheOutputStream(24);) {
            outputStream.write("hehe".getBytes(), 0, 4);
            System.out.println(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

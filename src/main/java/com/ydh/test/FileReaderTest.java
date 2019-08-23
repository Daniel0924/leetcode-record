package com.ydh.test;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ConcurrentHashMap;

public class FileReaderTest {

    public static void method() {
        String path = "//Users//daniel//Shell//doc//test.txt";

        RandomAccessFile aFile = null;

        try {
            aFile = new RandomAccessFile(path, "rw");

            FileChannel fileChannel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);
            int BytesRead = fileChannel.read(buf);

            while (BytesRead != -1) {
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.println((char) buf.get());
                }

                buf.compact();

                BytesRead = fileChannel.read(buf);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void method2() {


        String path = "//Users//daniel//Shell//doc//test.txt";
        BufferedInputStream input = null;

        File file = new File(path);

        System.out.println(file.getName());

        try {
            input = new BufferedInputStream(
                    new FileInputStream(path));

            byte[] buffer = new byte[1024];

            int read = input.read(buffer);

            while (read != -1) {
                /**
                 for (int i = 0; i < read; i++) {
                 System.out.println((char) buffer[i]);

                 }
                 **/
                read = input.read(buffer);
                System.out.println("read:" + read);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws Exception {

        String path = "//Users//daniel//Shell//doc//test.txt";

        FileInputStream fis = new FileInputStream(path);
        byte[] buf = new byte[1024];
        int num = 0;

        while ((num = fis.read(buf)) > 0) {
            System.out.println(new String(buf, 0, num));

        }

        ConcurrentHashMap map = new ConcurrentHashMap(100);
        fis.close();
    }
}

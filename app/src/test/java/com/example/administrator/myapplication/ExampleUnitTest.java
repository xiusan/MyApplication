package com.example.administrator.myapplication;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws IOException {
        String str = "This a string";
        ByteString byteString = ByteString.encodeUtf8(str);
        System.out.println(byteString);
        //获取图片 文件的base64
        String s = byteString.base64();
        System.out.println(s);
        ByteString byteString1 = ByteString.decodeBase64(s);
        //解码
        System.out.println(byteString1);
        //指纹md5
        ByteString byteString2 = byteString.md5();
        System.out.println(byteString2);

        //操作文件
        FileInputStream in = new FileInputStream("in.png");
        ByteString read = ByteString.read(in, in.available());
        System.out.println(read);
        FileOutputStream out = new FileOutputStream("out.png");
        read.write(out);

        in.close();
        out.close();

    }

    @Test
    public void test_buffer() throws IOException {

        BufferedSource buffer = Okio.buffer(Okio.source(new File("in.png")));
        //写入文件
        BufferedSink bufferSink = Okio.buffer(Okio.sink(new File("out.png")));
        buffer.readAll(bufferSink);
        BufferedSource buffer1 = Okio.buffer(Okio.source(new File("in.png")));
        //读取内容
        if (!buffer1.exhausted()){

            System.out.println(buffer1.readUtf8());
        }
        buffer.close();
        bufferSink.close();

    }
}
package com.example.administrator.myapplication.event;

import okio.ByteString;

public class Test {
    public static void main(String[] args) {
        String str = "This a string ";
        ByteString byteString = ByteString.encodeUtf8(str);
        System.out.println(byteString);
        System.out.println(byteString);

    }
}

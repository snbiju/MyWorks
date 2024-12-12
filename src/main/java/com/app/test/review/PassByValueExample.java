package com.app.test.review;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PassByValueExample {
    public static void main(String[] args) {
        int x = 10;
        modifyValue(x);
        System.out.println("Outside method: " + x); // Output: 10

        StringBuilder myStringBuilder = new StringBuilder("Hello");
        modifyStringBuilder(myStringBuilder);
        System.out.println("Outside method: " + myStringBuilder);
        modifyObject(myStringBuilder);
        System.out.println("after Modify Object:"+myStringBuilder);

    }

    public static void modifyValue(int value) {
        value = value+ 20;
        System.out.println("Inside method: " + value); // Output: 20
    }

    public static void modifyStringBuilder(StringBuilder sb) {
        sb.append(" World");
        System.out.println("Inside method: " + sb); // Output: Hello World
    }
    public static void modifyObject(StringBuilder str) {
        str = new StringBuilder("Goodbye");
    }
}

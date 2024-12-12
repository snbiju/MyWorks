package com.app.test.interview;

public class Constructor {
    static String str;
    public void Constructor(){
        System.out.println("In Costructor");
        str ="Hello";

    }

    public static void main(String[] args) {
        Constructor c = new Constructor();
        System.out.println(str);
    }
}

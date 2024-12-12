package com.app.test.tesco;

import java.util.Map;

public class OwnHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String,Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("One",1);
        myHashMap.put("Two",2);

        System.out.println(myHashMap.get("One"));
        System.out.println(myHashMap.get("Two"));

    }
}

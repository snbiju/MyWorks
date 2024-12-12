package com.app.test.concurrent;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


/*
ConcurrentHashMap: A thread-safe variant of HashMap that allows concurrent access and modifications.
CopyOnWriteArrayList: A thread-safe variant of ArrayList that provides safe iteration over the list, even while it is being modified.
 */
public class ConcurrentCollectionExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.forEach((key, value) -> System.out.println(key + ": " + value));
        map.computeIfPresent("A", (key, value) -> value + 1);
        System.out.println("Updated value of A: " + map.get("A"));

        List<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        for (String item : list) {
            System.out.println(item);
        }
        list.remove("A");
        System.out.println("Updated list: " + list);
    }
}

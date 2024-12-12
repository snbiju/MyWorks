package com.app.test.JP;

import java.util.*;
import java.util.stream.Collectors;

public class SortingKeyFromMap {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",11);
        map.put("w",9);
        map.put("c",7);
        map.put("d",5);
        map.put("b",4);
        map.put("n",1);

        map.forEach((k, v)-> System.out.println("Key: "+k + " value: "+v));



        LinkedHashMap<String,Integer> sortByKey =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("-------------------");

        sortByKey.forEach((k, v)-> System.out.println("Key: "+k + " value: "+v));

        LinkedHashMap<String,Integer> sortByValue =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("-------------------");

        sortByValue.forEach((k, v)-> System.out.println("Key: "+k + " value: "+v));
    }
}

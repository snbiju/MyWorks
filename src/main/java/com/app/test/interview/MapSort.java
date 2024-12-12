package com.app.test.interview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSort {

    public static Map<String,Double> getSortedKeyMap(Map<String,Double> valueMap){

        Map<String,Double> topTen =
                valueMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        topTen.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
        return topTen;
    }

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("A", 99.5);
        map.put("B", 67.4);
        map.put("C", 63.4);
        map.put("D", 67.3);
        getSortedKeyMap(map);
     //   System.out.println(getSortedKeyMap(map));
    }

}

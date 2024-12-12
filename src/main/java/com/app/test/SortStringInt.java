package com.app.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class SortStringInt {

    public static void main(String[] args) {
        String[] array ={"ABC34","XYS23","MNS11","ZZE10"};
        Map<String,String> maps = new TreeMap<>();
        Arrays.stream(array)
                        .forEach(x-> maps.put(x.substring(x.length()-2),x));


        maps.entrySet().stream().forEach(System.out::println);
      /*  for (Map.Entry<String,String> entry:maps.entrySet()
             ) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }*/

    }
}


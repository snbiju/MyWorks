package com.app.codes.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFilter {

    public static void main(String[] args) {
        Map<String,List<String>> myMap = new HashMap<>();
        String param = "Car";

        myMap.put("car", List.of("Toyota", "Honda", "Ford"));
        myMap.put("Van", List.of("Mahindra", "Force", "Standard"));
        myMap.put("Bus", List.of("Volvo", "Scanda", "Leyland"));

        myMap.entrySet().stream().filter(e->e.getKey().equalsIgnoreCase(param)).forEach(e->{System.out.println("Vechicle "+e.getValue());
        });
        myMap.entrySet()
                .stream()
                .filter(entry -> entry.getKey().contains(param))
                .forEach(entry -> {
                    System.out.println("Key: " + entry.getKey());
                    entry.getValue().forEach(System.out::println);
                });
    }
};

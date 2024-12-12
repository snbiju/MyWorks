package com.app.codes.practice.steam.exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1", "2", "three", "4", "5");

        try {
            List<Integer> integerList = stringList.stream()
                    .map(ExceptionUtil.wrap(s -> Integer.parseInt(s)))
                    .collect(Collectors.toList());

            System.out.println(integerList);
        } catch (RuntimeException e) {
            System.out.println("An error occurred: " + e.getCause().getMessage());
        }
    }


}


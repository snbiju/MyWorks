package com.app.codes.interview.rateLimiter;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add("second");
        list.add("third");

        for (String element : list) {
            System.out.println("Element: " + element);
        }
    }
}

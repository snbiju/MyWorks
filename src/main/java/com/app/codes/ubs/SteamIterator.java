package com.app.codes.ubs;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SteamIterator {
    public static void main(String[] args) {
        System.out.println(func(7));
        System.out.println(func(8));

    }

   /* int func(1int n) {
        int sum = Stream.iterate(new int[]{0, 1},
                tint sum = Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
                        .limit(n)
                        .map(x -> x[0])
                        .collect(toList())
                        .stream()
                        .distinct()
                        .filter(i -> i % 2 == 0)
                        .mapToInt(i -> i)
                        .sum();
        return sum;

    }*/

    public static int func(int n) {
        // Generate the first n Fibonacci numbers
        int sum = Stream.iterate(new int[]{0, 1},
                        x -> new int[]{x[1], x[0] + x[1]})
                .limit(n)
                .map(x -> x[0])
                .collect(toList()).stream()
                .distinct()
                .filter(i -> i % 2 == 0)
                .mapToInt(i -> i)
                .sum();

        return sum;
    }
}

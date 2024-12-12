package com.app.test.practice;

import java.util.*;
import java.io.*;

public class FindMexForEachElement {
    public static void main(String[] args) throws IOException {
        int[] array;
        boolean [] contains;
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            contains = new boolean[size*size];
            int min = 0;
            var sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                contains[array[i]] = true;
                while (contains[min]) {
                    min++;
                }
                sb.append(min).append(' ');
            }
            System.out.println(sb);
        }
    }
}


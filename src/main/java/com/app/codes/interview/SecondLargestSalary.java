package com.app.codes.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SecondLargestSalary {
    public static void main(String[] args) {
        List<Integer> salaries = List.of(4,8,7,6,9,4);
        System.out.println(salaries.stream().distinct().sorted().skip(salaries.size()-2).findFirst().get());
        List<Integer> sal=salaries.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(sal.stream().skip(sal.size()-2).findFirst().get());
        List<Integer> salaries1 = new ArrayList<>();
        salaries1.add(4);
        salaries1.add(8);
        salaries1.add(7);
        salaries1.add(6);
        salaries1.add(9);
        salaries1.add(4);

    }

}

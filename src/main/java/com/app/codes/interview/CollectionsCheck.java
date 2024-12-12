package com.app.codes.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsCheck {

    public static void collectionTest(){

        List<Integer> salaryList = new ArrayList<>();

        salaryList.add(3000);
        salaryList.add(1000);
        salaryList.add(4000);
        salaryList.add(10000);
        salaryList.add(5500);
        salaryList.add(8000);
        salaryList.add(6000);
        salaryList.add(7500);
        salaryList.stream().forEach(x->System.out.print(x+" "));
        System.out.println("--------------");
        System.out.println(salaryList.stream().min((x,y)->x.compareTo(y)).get());
        System.out.println(salaryList.stream().max((x,y)->x.compareTo(y)).get());
       List<Integer> sortedList= salaryList.stream().sorted((x,y)->y.compareTo(x)).collect(Collectors.toList());
        System.out.println("--------------");
        sortedList.stream().forEach(x->System.out.print(x+" "));

        sortedList.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        CollectionsCheck.collectionTest();
    }
}

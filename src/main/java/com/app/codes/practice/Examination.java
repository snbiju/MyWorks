package com.app.codes.practice;

import java.util.*;

public class Examination {



    static void getResult(){

        Set<String> elements = new HashSet<>();
        elements.add("One");
        elements.add("Two");
        elements.add("Three");
        elements.add("Four");
        elements.add("Five");
        elements.add("Six");
        System.out.println("----------Set Hash Set-----------------");
        System.out.println();

        elements.stream().forEach(System.out::println);

        System.out.println("----------Set Linked Hash Set-----------------");
        System.out.println();
        Set<String> elements1 = new LinkedHashSet<>();
        elements1.add("One");
        elements1.add("Two");
        elements1.add("Three");
        elements1.add("Four");
        elements1.add("Five");
        elements1.add("Six");

        elements1.stream().forEach(System.out::println);
        System.out.println("--------Set TreeSet-------------------");
        System.out.println();
        Set<String> elements2 = new TreeSet<>();
        elements2.add("One");
        elements2.add("Two");
        elements2.add("Three");
        elements2.add("Four");
        elements2.add("Five");
        elements2.add("Six");
        elements2.stream().forEach(System.out::println);


        List<String> list1= new ArrayList<>(elements1);

        System.out.println("---------List - ArrayList------------------");
        System.out.println();
        list1.stream().forEach(System.out::println);

        System.out.println("---------List - LikedList------------------");
        System.out.println();
        LinkedList<String> list2 = new LinkedList<>(elements1);
        list2.stream().forEach(System.out::println);
        System.out.println(list2.get(2));
        



    }
    public static void main(String[] args) {
        Examination.getResult();
    }
}

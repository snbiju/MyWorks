package com.app.test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MyTest {

    public static void main(String[] args) {
        System.out.println("Test");
        LocalDate dateTime=LocalDate .parse("2021-09-26");
        LocalDateTime dateTime1 = LocalDateTime.parse("2021-09-26T11:36");
        System.out.println(dateTime1);
       // System.out.println(dateTime);
    }
}

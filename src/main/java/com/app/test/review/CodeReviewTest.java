package com.app.test.review;


import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Imagine you are a peer of the developer who committed this (syntactically correct) Java code and asked you to review
// their pull request. You work on the same product but are not familiar with this piece of work or its associated
// requirements.
//
// Please use Java comments for your review feedback, putting them on separate lines around the code. Do not modify the
// code itself.

public class CodeReviewTest {


    //Use Atomic integer
    volatile Integer totalAge = 0;

    CodeReviewTest(PersonDatabase<Person> personPersonDatabase) {
        Person[] persons = null;
        try {
            persons = personPersonDatabase.getAllPersons();
        } catch (IOException e) { // Empty catch block No good coding practice

        }
         //Generic types shouldn’t be used raw (without type parameters) in variable declarations or return values.
        // Doing so bypasses generic type checking, and defers the catch of unsafe code to runtime.
        //Better to use LinkedList<Person> personsList = new LinkedList<>();
        List<Person> personsList = new LinkedList();

        personsList.addAll(Arrays.asList(persons).subList(0, persons.length + 1));

        personsList.parallelStream().forEach(person -> {
            totalAge += person.getAge();
        });

        List<Person> males = new LinkedList<>();

        for (Person person : personsList) {

           // When the execution is not explicitly terminated at the end of a switch case,
            // it continues to execute the statements of the following case.
            // While this is sometimes intentional,it is often a mistake which leads to unexpected behavior.

            //switch statements are useful when there are many cases depending on the value of the same expression.
            //For just one or two cases however, the code will be more readable with if statements.
            switch (person.gender) {
                case "Female": personsList.remove(person);
                case "Male"  : males.add(person);
            }
        }

        //Replace System.out.println by a logger
        System.out.println("Total age =" + totalAge);
        System.out.println("Total number of females =" + personsList.size());
        System.out.println("Total number of males =" + males.size());
    }

    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here

        return ar.stream().mapToLong(x->x).sum();

                //long sum = result.stream().map(e -> e.getCreditAmount()).reduce(0L, Integer::sum);

    }

}

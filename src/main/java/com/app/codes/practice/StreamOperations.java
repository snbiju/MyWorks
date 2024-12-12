package com.app.codes.practice;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {

    enum Gender {
        MALE, FEMALE
    }

    record Employee(String name, int age, int salary, Gender gender) {
    }
    public static void main(String[] args) {

        //transform each pet name to uppercase using the map operation and collect the resulting uppercase names into a new list using the toList collector.
        List<String> pets = List.of("Hamster", "Cat", "Dog");
        List<String> upperCaseNames = pets
                .stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(upperCaseNames);
        assert List.of("HAMSTER", "CAT", "DOG").equals(upperCaseNames);

        //filter is used to selectively include elements in the stream based on a specified condition.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers
                .stream()
                .filter(number -> number % 2 == 0)
                .toList();
        System.out.println(evenNumbers);
        assert List.of(2, 4, 6, 8, 10).equals(evenNumbers);

        //By using the collect method with the Collectors.toSet collector,transform the stream of fruits into a set, ensuring uniqueness of elements.

        List<String> fruits = List.of("apple", "peach", "banana", "cherry", "banana", "peach");
        Set<String> fruitSet = fruits
                .stream()
                .collect(Collectors.toSet());
        System.out.println(fruitSet);
        assert fruitSet.size() == 4;


        //flatMap is used to merge a stream of streams into a single stream, thus effectively flattening nested structures.
        List<List<String>> shapes = List.of(
                List.of("triangle", "rectangle", "square"), // sharp forms
                List.of("circle", "ellipse", "cylinder") // rounded forms
        );

        List<String> flattenedShapes = shapes
                .stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println(flattenedShapes);
        assert flattenedShapes.size() == 6;
        assert List.of("triangle", "rectangle", "square", "circle", "ellipse", "cylinder").equals(flattenedShapes);

        //reduce combines elements of the stream into a single result with an accumulation function, thus simplifying complex computations.
        //Integer::sum method reference as the binary operator to perform the summation.
        // The result, stored in the sum variable, represents the total sum of the numbers in the list.
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
        Integer sum = numbers1
                .stream()
                .reduce(0, Integer::sum);

        System.out.println(sum);
        assert sum == 15;

        //forEach allows us to loop through each element in the stream, enabling us to perform an action
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5);
        numbers2.forEach(num -> System.out.println(num * 2));

        //distinct removes duplicate elements from the stream, ensuring uniqueness in the output.
        List<Integer> numbers3 = List.of(1, 2, 3, 4, 4, 4, 5);
        List<Integer> distinctNumbers = numbers3
                .stream()
                .distinct()
                .toList();
        System.out.println(distinctNumbers);
        assert List.of(1, 2, 3, 4).equals(distinctNumbers);

        //sorted is used to sort elements in the stream according to their natural order or a custom comparator that we provide.
        List<Integer> numbers4 = List.of(3, 1, 6, 8, 2, 4, 5, 9, 7);
        List<Integer> sorted = numbers4
                .stream()
                .sorted()
                .toList();
        System.out.println(sorted);
        assert List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).equals(sorted);

        //skip enables us to skip a designated number of elements from the start of the stream,
        // while limit enables us to specify the maximum number of elements we wish to process from the beginning.

        List<Integer> numbers5 = List.of(1, 2, 3, 4, 5);
        List<Integer> skipped = numbers5
                .stream()
                .skip(2)
                .toList();

        System.out.println(skipped);
        assert List.of(3, 4, 5).equals(skipped);

        List<Integer> limited = numbers5
                .stream()
                .limit(3)
                .toList();
        System.out.println(limited);
        assert List.of(1, 2, 3).equals(limited);

        //anyMatch, noneMatch, allMatch — these operations allow us to specify conditions and check if any, none, or all items in the stream match them.


        List<Integer> numbers6 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        assert Boolean.TRUE.equals( // Is any of the numbers equal to 5?
                numbers6
                        .stream()
                        .anyMatch(num -> num == 5)
        );

        System.out.println("Boolean True:"+Boolean.TRUE.equals( // Is any of the numbers equal to 5?
                numbers6
                        .stream()
                        .anyMatch(num -> num == 5)));

        assert Boolean.FALSE.equals( // Is any of the numbers equal to 15?
                numbers6
                        .stream()
                        .anyMatch(num -> num == 15)
        );

        assert Boolean.TRUE.equals( // None of the numbers is equal to 15
                numbers6
                        .stream()
                        .noneMatch(num -> num == 15)
        );

        assert Boolean.FALSE.equals( // None of the numbers is equal to 3
                numbers6
                        .stream()
                        .noneMatch(num -> num == 3)
        );

        assert Boolean.TRUE.equals( // All of the numbers are greater than 0
                numbers6
                        .stream()
                        .allMatch(num -> num > 0)
        );

        assert Boolean.FALSE.equals( // All of the numbers are even
                numbers6
                        .stream()
                        .allMatch(num -> num % 2 == 0)
        );


        //Advanced
        Employee employee1 = new Employee("John", 20, 2000, Gender.MALE);
        Employee employee2 = new Employee("Jane", 28, 2000, Gender.FEMALE);
        Employee employee3 = new Employee("Alex", 38, 2750, Gender.MALE);
        Employee employee4 = new Employee("Mary", 35, 3500, Gender.FEMALE);
        Employee employee5 = new Employee("Pedro", 40, 3100, Gender.MALE);

        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5);

       // What is the total salary of male employees aged over 25?
        double summed = employees
                .stream()
                .filter(employee -> employee.gender.equals(Gender.MALE) && employee.age > 25)
                .mapToDouble(Employee::salary)
                .sum();
        System.out.println(summed);
        assert summed == 2750 + 3100;

        //Does a female employee under the age of 30 named ‘Jane’ exist?

        boolean existsFemaleEmployeeWithName = employees
                .stream()
                .filter(employee -> employee.gender.equals(Gender.FEMALE) && employee.age < 30)
                .anyMatch(employee -> employee.name.equals("Jane"));
        assert existsFemaleEmployeeWithName;

        //What is the total salary budget for all employees?

        Integer totalSalaryBudget = employees
                .stream()
                .map(Employee::salary)
                .reduce(0, Integer::sum);
        assert totalSalaryBudget == 2000 + 2000 + 2750 + 3500 + 3100;

        //What are the top three highest salaries among the employees?

        List<Integer> top3HighestSalaries = employees
                .stream()
                .map(Employee::salary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        assert List.of(3500, 3100, 2750).equals(top3HighestSalaries);

        //What is the total salary for each gender group among employees over the age of 20?

        Map<Gender, Integer> genderToTotalSalaryMap = employees
                .stream()
                .filter(employee -> employee.age > 20)
                .collect(Collectors.groupingBy(Employee::gender, Collectors.summingInt(Employee::salary)));
        assert genderToTotalSalaryMap.get(Gender.MALE) == 2750 + 3100;
        assert genderToTotalSalaryMap.get(Gender.FEMALE) == 2000 + 3500;


        //Method Chaining
        List<String> words = Arrays.asList("apple", "banana", "cat", "dog");

        long count = words.stream()          // Make a stream
                .filter(word -> word.length() > 3)  // Filter out short words
                .map(String::toUpperCase)           // Convert remaining words to uppercase
                .count();                           // Count how many words are left

        //Lazy Evaluation
        List<Integer> numbers7 = Arrays.asList(5, 12, 8, 3, 15, 20);

        Integer result = numbers7.stream()
                .filter(n -> n % 2 == 0) // Only even numbers
                .filter(n -> n > 10)     // Only numbers greater than 10
                .findFirst()              // Find the first matching number
                .orElse(null);            // Return null if no match


        System.out.println(result);


        //Parallel Processing

        List<Integer> numbers8 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum1 = numbers8.parallelStream() // Process in parallel
                .mapToInt(n -> n)              // Convert to IntStream
                .sum();                        // Add up all the numbers

        System.out.println(sum1);

        //Immutable Data

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        List<String> upperCaseNames1 = names.stream() // Make a stream
                .map(String::toUpperCase)               // Make all names uppercase
                .collect(Collectors.toList());         // Collect into a new list


        System.out.println(upperCaseNames1);

        //Optional

        List<String> fruitss = List.of();
        Optional<String> firstFruit = fruitss.stream() // Make a stream
                .findFirst();                             // Find the first fruit

        System.out.println(firstFruit);

    }


}

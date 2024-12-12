package com.app.test.practice;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/*
Traditional Approach with if-else:
 */
public class TraditionalIfElse {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();

    static {
        operations.put("add", (a, b) -> a + b);
        operations.put("subtract", (a, b) -> a - b);
        operations.put("multiply", (a, b) -> a * b);
        operations.put("divide", (a, b) -> {
            if (b == 0) throw new ArithmeticException("Cannot divide by zero");
            return a / b;
        });
    }

    public static int calculate(int a, int b, String operation) {
        BiFunction<Integer, Integer, Integer> func = operations.get(operation);
        if (func == null) {
            throw new UnsupportedOperationException("Invalid operation");
        }
        return func.apply(a, b);
    }

    public static void main(String[] args) {
        int a = 10, b = 5;
        System.out.println("Add: " + calculate(a, b, "add"));
        System.out.println("Subtract: " + calculate(a, b, "subtract"));
        System.out.println("Multiply: " + calculate(a, b, "multiply"));
        System.out.println("Divide: " + calculate(a, b, "divide"));
    }
    
    double result;
    double getResult(int a, int b) {
        Map<String, String> operations = new HashMap<>();
        if (operations.equals("add")) {
            result = a + b;
        } else if (operations.equals("subtract")) {
            result = a - b;
        } else if (operations.equals("multiply")) {
            result = a * b;
        } else if (operations.equals("divide")) {
            result = a / b;
        } else {
            throw new UnsupportedOperationException("Invalid operation");
        }
        return 0;
    }


}
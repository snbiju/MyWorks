package com.app.codes.practice;

public class BitwiseShiftExample {
    public static void main(String[] args) {
        int number = 21; // Binary: 0001 0101

        // Left Shift by 2
        int leftShift = number << 2; // 84
        System.out.println("Left Shift: " + leftShift);

        // Arithmetic Right Shift by 2
        int rightShiftArithmetic = number >> 2; // 5
        System.out.println("Arithmetic Right Shift: " + rightShiftArithmetic);

        // Logical Right Shift by 2
        int rightShiftLogical = number >>> 2; // 5
        System.out.println("Logical Right Shift: " + rightShiftLogical);
    }
}


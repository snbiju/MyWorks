package com.app.test.GS;

public class PowerWithoutExponentiation {

    public static void main(String[] args) {
        int base = 2;
        int exponent = 5;

        long result = power(base, exponent);
        System.out.println(base + " ^ " + exponent + " = " + result);
    }

    public static long power(int base, int exponent) {
        if (exponent < 0) {
            return -1; // Handle negative exponents if needed
        }

        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return result;
    }
}


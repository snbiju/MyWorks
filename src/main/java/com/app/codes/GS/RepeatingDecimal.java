package com.app.codes.GS;

/*
Mistery of repeating decimal

(1,3)--> 0.(3)
(1,4)-->0.25
(1,6)-->0.1(6)
(1,7)->0.(142857)
(1,8)->0.125
(1,9)-> 0.(1)

Few point to consider
1. Check if denominator is 0
2. Check if numerator is 0
3. Check if reminder is 0
4. Check if numerator or denominator is negative


Time Complexity:
The time complexity of the fractionToDecimal function is O(log(N)), where N is the absolute value of the numerator.
This is because the algorithm performs division and multiplication in a loop, and the number of iterations
is determined by the number of digits in the result.

Space Complexity:
The space complexity is O(log(N)), where N is the absolute value of the numerator.
This is because the algorithm uses a StringBuilder to store the result, and the length of the result string is proportional to
the number of digits in the result. Additionally, the algorithm uses a HashMap to keep track of remainders, and in the worst case,
the number of unique remainders stored in the map is proportional to the number of digits in the result.
 */

import java.util.HashMap;
import java.util.Map;

public class RepeatingDecimal {

    public static void main(String[] args) {
        int numerator = 1;
        int denominator = 3;

        System.out.println(fractionToDecimal(55, 17));
        System.out.println(fractionToDecimal(numerator, 0));
        System.out.println(fractionToDecimal(numerator, denominator));

        numerator = 1;
        denominator = 4;
        System.out.println(fractionToDecimal(numerator, denominator));

        numerator = 1;
        denominator = 6;
        System.out.println(fractionToDecimal(numerator, denominator));

        numerator = 1;
        denominator = 7;
        System.out.println(fractionToDecimal(numerator, denominator));

        numerator = 1;
        denominator = 8;
        System.out.println(fractionToDecimal(numerator, denominator));

        numerator = 1;
        denominator = 9;
        System.out.println(fractionToDecimal(numerator, denominator));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "Arithmetic Exception- not defined";
        }

        StringBuilder result = new StringBuilder();
        result.append((numerator > 0) ^ (denominator > 0) ? "-" : "");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(num / den);

        long remainder = num % den;
        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                result.insert(map.get(remainder), "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }
}


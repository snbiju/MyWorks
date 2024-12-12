package com.app.codes.hackerrank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrintsTheTimeInWords {
    /**
     * Write a program which prints the time in words for the input given in the
     * format mentioned above.
     *
     * @param h
     *            Represents the hours
     * @param m
     *            Represents the minutes
     * @return Time in a human-readable string
     */


    public static String convertTimeToWords1(int h, int m) {
        String[] numbers = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                "nineteen", "twenty"};

        if (m == 0) {
            return numbers[h] + " o' clock";
        } else if (m == 15) {
            return "quarter past " + numbers[h];
        } else if (m == 30) {
            return "half past " + numbers[h];
        } else if (m == 45) {
            return "quarter to " + numbers[(h % 12) + 1];
        } else if (m == 1) {
            return "one minute past " + numbers[h];
        } else if (m < 30) {
            if (m <= 20) {
                return numbers[m] + (m == 1 ? " minute" : " minutes") + " past " + numbers[h];
            } else {
                return "twenty " + numbers[m - 20] + " minutes past " + numbers[h];
            }
        } else {
            m = 60 - m;
            if (m <= 20) {
                return numbers[m] + (m == 1 ? " minute" : " minutes") + " to " + numbers[(h % 12) + 1];
            } else {
                return "twenty " + numbers[m - 20] + " minutes to " + numbers[(h % 12) + 1];
            }
        }
    }

    public static String convertTimeToWords(int h, int m) {
        String[] numbers = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                "nineteen", "twenty"};
        String result="";

        if (m == 0) {
            result= numbers[h] + " o' clock";
        } else if (m == 15) {
            result= "quarter past " + numbers[h];
        } else if (m == 30) {
            result= "half past " + numbers[h];
        } else if (m == 45) {
            result= "quarter to " + numbers[(h % 12) + 1];
        } else if (m == 1) {
            result= "one minute past " + numbers[h];
        } else if (m < 30) {
            if(m>15){
                result=numbers[(h % 12)]+" "+ numbers[m];
            }
            if (m < 15) {
                result= numbers[m] + (m == 1 ? " minute" : " minutes") + " past " + numbers[h];
            } /*else {
                return "twenty " + numbers[m - 20] + " minutes past " + numbers[h];
            }*/
        } else {
            m = 60 - m;
            if (m <= 20) {
                result= numbers[m] + (m == 1 ? " minute" : " minutes") + " to " + numbers[(h % 12) + 1];
            } else {
                result= "twenty " + numbers[m - 20] + " minutes to " + numbers[(h % 12) + 1];
            }
        }
        return result;
    }

    public static String getTime(int hh, int mm) {

        String[] lowDigits = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
        // 678
        String output = "";
        if (mm == 15 || mm == 30 || mm == 45 || mm == 00) {
            switch (mm) {
                case 15:
                    output += "quarter past " + lowDigits[hh];
                    break;
                case 30:
                    output += "half past " + lowDigits[hh];
                    break;
                case 45:
                    output += "quarter to " + lowDigits[hh + 1];
                    break;
                case 00:
                    output += lowDigits[hh] += " o' clock";
                    break;
                default:
                    output += "ERROR";
                    break;
            }
        } else if (mm < 20) {
            int rmn = mm % 10;
            if (mm == 1)
                output += lowDigits[mm] + " minute past " + lowDigits[hh];
            else
                output += lowDigits[mm] + " minutes past " + lowDigits[hh];
        } else if (mm < 30 && mm > 20) {
            int div = mm / 10;
            if (div > 0)
                output += tens[div] + " ";
            int rmn = mm % 10;
            output += lowDigits[rmn];
            output += " minutes past " + lowDigits[hh];
        } else if (mm > 30 && mm < 60) {
            mm = 60 - mm;
            if (mm < 20) {
                int rmn = mm % 10;
                output += lowDigits[mm];
                output += " minutes to " + lowDigits[hh + 1];
                return output;
            }
            int div = mm / 10;
            if (div > 0)
                output += tens[div] + " ";
            int rmn = mm % 10;
            output += lowDigits[rmn];
            output += " minutes to " + lowDigits[hh + 1];
        }
        // System.out.println("Ouput is "+output);
        return output;
    }

    static void printBigDecimal(){
        BigDecimal num1 = new BigDecimal("10.123456789");
        BigDecimal num2 = new BigDecimal("20.987654321");

        // Addition
        BigDecimal sum = num1.add(num2);
        System.out.println("Sum: " + sum.setScale(5, RoundingMode.HALF_UP));

        // Multiplication
        BigDecimal product = num1.multiply(num2);
        System.out.println("Product: " + product);
    }
    public static void main(String[] args) {
     //   System.out.println(getTime(22,50));
        System.out.println(convertTimeToWords(22,50));
        System.out.println(convertTimeToWords(23,59));
        System.out.println(convertTimeToWords(3,31));
        System.out.println(convertTimeToWords(3,16));
        System.out.println(convertTimeToWords(3,14));
        printBigDecimal();

    }
}

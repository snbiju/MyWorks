package com.app.test.hackerrank;

public class PrintGivenNumberToEnglishText {
    /**
     * Converts the given number to its readable English text in the range of
     * 1-1000.
     *
     * @param num
     */
    private static String convertNumberToWord(int num) {
        String[] lowDigits = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", " nine", " ten",
                " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen",
                " nineteen" };
        String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
        // 678
        String output = "";
        if (num > 100 && num < 1000) {
            int div = num / 100;
            output = lowDigits[div] + " hundred ";
            int rem = num % (div * 100);
            int mo = rem / 10;
            if (mo > 0)
                output += tens[mo] + " ";

            int ld = rem % 10;
            output += lowDigits[ld];
            System.out.println(output);
        } else if (num < 100 && num > 0) {
            int div = num / 10;
            if (div > 1)
                output += tens[div] + " ";
            int rmn = num % 20;
            output += lowDigits[rmn] + " ";
            System.out.println("Output is " + output);
        } else if (num == 100 || num == 0) {
            switch (num) {
                case 100:
                    output += "one hundred";
                    break;
                case 0:
                    output += "zero";
                    break;
                default:
                    output += "none";
                    break;
            }
        }
        System.out.println("Output is " + output);
        return output;
    }
}

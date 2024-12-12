package com.app.codes;

public class ReverseASCIIPassword {
    public static void main(String[] args) {
        String input = "766115110113721110141108";
        int[] reverseASCIIPassword = parseInput(input);
        String password = decodePassword(reverseASCIIPassword);
        System.out.println("Aman's LinkedIn Password: " + password);

        char[] arr =input.toCharArray();
        System.out.println("Aman's LinkedIn Password: " + decodeASCIIPassword(arr));
    }

    public static String decodeASCIIPassword(char[] arr) {
        String current = "";
        String result = "";

        for (int i = arr.length - 1; i >= 0; i = i - 2) {
            current = "" + arr[i] + arr[i - 1];
            int n = Integer.parseInt(current);

            if (n == 32) {
                result += " ";
            } else if ((n >= 65 && n <= 90) || (n >= 97 && n <= 122)) {
                result += (char) n;
            } else {
                if (i - 2 >= 0) {
                    current += arr[i - 2];
                    n = Integer.parseInt(current);
                    result += (char) n;
                    i--;
                } else {
                    break;
                }
            }
        }

        return result;
    }


    public static int[] parseInput(String input) {
        int[] values = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            values[i] = Character.getNumericValue(input.charAt(i));
        }

        return values;
    }

    public static String decodePassword(int[] reverseASCIIPassword) {
        StringBuilder password = new StringBuilder();

        for (int i = reverseASCIIPassword.length - 1; i >= 0; i--) {
            password.append((char) reverseASCIIPassword[i]);
        }

        return password.toString();
    }
}


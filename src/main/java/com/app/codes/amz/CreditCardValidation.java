package com.app.codes.amz;

/*

This program uses the Luhn algorithm to check the validity of a credit card number.
Users can enter credit card numbers with or without spaces. The program removes spaces and then performs the validation.
Note that this is a basic example, and in a real-world scenario, additional checks and validation methods may be required.

Time Complexity:
The time complexity of the program is O(n), where n is the length of the credit card number.
The program iterates through each digit of the credit card number once to perform the Luhn algorithm, making it a
linear time complexity.

Space Complexity:
The space complexity of the program is O(1), which is constant.
The amount of additional space used by the program does not grow with the input size.
The space required is mainly for a few integer variables used in the algorithm, making it constant space.
 */

public class CreditCardValidation {

    public static boolean isValidCreditCard(String creditCardNumber) {
        String creditCard = creditCardNumber.replaceAll("\\s", "");
        int n = creditCard.length();
        int sum = 0;
        boolean alternate = false;

        for (int i = n - 1; i >= 0; i--) {
            int digit = creditCard.charAt(i) - '0';

            if (alternate) {
                digit *= 2;

                if (digit > 9) {
                    digit = digit % 10 + 1;
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        return sum % 10 == 0;
    }

    public static void main(String[] args) {
      //  Scanner scanner = new Scanner(System.in);

      //  System.out.print("Enter the credit card number: ");
        String creditCardNumber = "4659 4413 1944 2085";

        if (isValidCreditCard(creditCardNumber)) {
            System.out.println("Valid credit card number.");
        } else {
            System.out.println("Invalid credit card number.");
        }

    }
}


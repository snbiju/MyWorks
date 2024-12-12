package com.app.codes.ubs;

public class CreditCardValidator {
    public static void main(String[] args) {
        String creditCardNumber = "1111111111111111"; // Replace with the credit card number to validate

        String creditCardNumber2 = "4111111111111111";
        System.out.println("r3et:"+isValidCreditCard("4242424242426742"));
        System.out.println("r3et2:"+isValidCreditCard(creditCardNumber));

        if (isValidCreditCard(creditCardNumber)) {
            System.out.println("Valid credit card number");
        } else {
            System.out.println("Invalid credit card number");
        }
    }

    public static boolean isValidCreditCard(String cardNumber) {
        int length = cardNumber.length();
        int sum = 0;
        boolean doubleDigit = false;

        for (int i = length - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));

            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            doubleDigit = !doubleDigit;
        }

        return (sum % 10 == 0);
    }

    private static boolean isValidCreditCard1(String creditCardNumber) {
        // Remove any non-digit characters
        creditCardNumber = creditCardNumber.replaceAll("\\D", "");

        // Check if the credit card number is the correct length
        if (creditCardNumber.length() != 16) {
            return false;
        }

        int sum = 0;

        // Double every second digit from the right
        for (int i = creditCardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(creditCardNumber.charAt(i));

            if (i % 2 == 1) {
                digit *= 2;

                // If the result is a two-digit number, add its digits together
                if (digit > 9) {
                    digit = digit % 10 + 1;
                }
            }

            sum += digit;
        }

        // Check if the total sum ends in zero
        return sum % 10 == 0;
    }
}

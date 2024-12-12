package com.app.test.php;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1HashingExample {
    public static void main(String[] args) {
        String originalString = "Hello, world!";

        // Hash the original string using SHA-1
        String hashedString = hashStringSHA1(originalString);

        // Print the original and hashed strings
        System.out.println("Original String: " + originalString);
        System.out.println("Hashed String (SHA-1): " + hashedString);
        System.out.println("String: "+hexToString(hashedString));
    }

    /**
     * Hashes a given string using the SHA-1 algorithm.
     *
     * @param input The input string to hash.
     * @return The hashed string in hexadecimal format.
     */
    public static String hashStringSHA1(String input) {
        try {
            // Get a MessageDigest instance for SHA-1
            MessageDigest digest = MessageDigest.getInstance("SHA-1");

            // Compute the hash of the input string
            byte[] hashBytes = digest.digest(input.getBytes());

            // Convert the hash bytes to hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Converts a hexadecimal string back to a readable string.
     *
     * @param hexString The hexadecimal string to convert.
     * @return The original string.
     */
    public static String hexToString(String hexString) {
        // Convert the hex string to a byte array
        byte[] bytes = hexStringToByteArray(hexString);

        // Convert the byte array to a readable string using UTF-8 encoding
        return new String(bytes);
    }


    /**
     * Converts a hexadecimal string to a byte array.
     *
     * @param hexString The hexadecimal string to convert.
     * @return The resulting byte array.
     */
    public static byte[] hexStringToByteArray(String hexString) {
        int length = hexString.length();
        byte[] bytes = new byte[length / 2];

        for (int i = 0; i < length; i += 2) {
            String hexByte = hexString.substring(i, i + 2);
            bytes[i / 2] = (byte) Integer.parseInt(hexByte, 16);
        }

        return bytes;
    }
}

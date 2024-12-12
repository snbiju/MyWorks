package com.app.codes.ubs;

public class RunLengthEncoding {

    public static String runCountElement(String element){
        StringBuilder builder = new StringBuilder();
        String letter;
        int count =0;


        for (int i=0;i<element.length();i++
             ) {
            letter=Character.toString(element.charAt(i));
            count++;
            if(i<element.length()-1) {
                for (int j = i + 1; j < element.length(); j++) {
                    if (letter.equalsIgnoreCase(Character.toString(element.charAt(j)))) {
                        count++;
                        i++;
                    } else {
                        builder.append(letter + count);
                        count = 0;
                        break;
                    }
                }
            }else {
                if(letter.equalsIgnoreCase(Character.toString(element.charAt(i-1)))){
                    count++;
                    builder.append(letter + count);
                }else{
                    builder.append(letter + 1);
                }
            }


        }


        return builder.toString();


    }

    public static String runLengthEncode(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                result.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        // Handle the last character
        result.append(input.charAt(input.length() - 1)).append(count);

        return result.toString();
    }

    public static void main(String[] args) {
        String str="aabbbcaad";
        System.out.println("Original String: " + str);
        System.out.println(runLengthEncode(str));

        String str1="aabbbcaadd";
        System.out.println("Original String: " + str1);
        System.out.println(runLengthEncode(str1));
        String str2="aabbbcaada";
        System.out.println("Original String: " + str2);
        System.out.println(runLengthEncode(str2));
        String input = "AAAABBBCCDAA";
        String encoded = runLengthEncode(input);

        System.out.println("Original String: " + input);
        System.out.println("Encoded String: " + encoded);

    }
}

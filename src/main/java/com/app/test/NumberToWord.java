package com.app.test;
/*
Time Complexity:
The method iterates over the numberMap map, which contains a constant number of entries (36 in this case).
So, the loop has a constant time complexity, O(1).

The loop iterates over the keys of numberMap, which is done in a fixed number of iterations (36 in this case). So, it's also O(1).

Inside the loop, there is a constant number of operations for each iteration, such as divisions, lookups, and appends.
Therefore, the time complexity of these operations is also constant, O(1).

The overall time complexity of the method is constant, O(1), as the number of iterations and operations remains the
same regardless of the input number.

Space Complexity:
The method uses a numberMap map, which contains a constant number of entries (36 in this case).
Therefore, the space complexity of the map is O(1).

The method creates a StringBuilder named word, which grows linearly with the length of the output string.
 In the worst case, the length of the output string is proportional to the number of digits in the input number.

Therefore, the space complexity related to the StringBuilder is O(d), where d is the number of digits in the input number.

The overall space complexity of the method is O(1 + d), where 1 represents the constant space used by the map,
 and d represents the linear space used by the StringBuilder.

In summary, the time complexity is O(1), and the space complexity is O(1 + d),
 where d is the number of digits in the input number.

 */

import java.util.*;

public class NumberToWord {
    private final Map<Integer, String> numbers = new HashMap<>();
    private final Set<Integer> numberSet = new TreeSet<>((o1, o2) -> o2 - o1);

    NumberToWord() {
        init();
        numberSet.addAll(numbers.keySet());
    }

    /*
     * convert positive numbers in word format number > 0 only
     */
    String getNumberInWord(int number) throws InvalidNumberException {
        if (number < 0) {
            throw new InvalidNumberException("Negative Number Not Allowed");
        }
        StringBuilder word = new StringBuilder();
        int input = number;
        for (Integer n : numberSet) {
            if (number > 0 && number >= n) {
                int div = number / n;
                String strNum = numbers.get(div);
                if (strNum == null) {
                    word.append(getNumberInWord(div));
                }
                // for less than 100, we don't need to say 1
                if (strNum != null && (div > 1 || n > 100))
                    word.append(strNum + " ");

                word.append(numbers.get(n) + " ");
                number = number % n;
            }
        }
     /*   if(input>100){
            String wordNum= word.toString().trim();
        }
        String[] wordList = word.toString().split(" ");
        StringBuilder builder= new StringBuilder();
            for (int i = 0; i < wordList.length - 2; i++) {
                builder.append(wordList[i]).append(" ");
            }
            builder.append("and "+wordList[wordList.length-2]+" " + wordList[wordList.length-1]);
*/
        return word.toString();
    }

    void init() {
        numbers.put(0, "Zero");
        numbers.put(1, "One");
        numbers.put(2, "Two");
        numbers.put(3, "Three");
        numbers.put(4, "Four");
        numbers.put(5, "Five");
        numbers.put(6, "Six");
        numbers.put(7, "Seven");
        numbers.put(8, "Eight");
        numbers.put(9, "Nine");
        numbers.put(10, "Ten");
        numbers.put(11, "Eleven");
        numbers.put(12, "Twelve");
        numbers.put(13, "Thirteen");
        numbers.put(14, "Fourteen");
        numbers.put(15, "Fifteen");
        numbers.put(16, "Sixteen");
        numbers.put(17, "Seventeen");
        numbers.put(18, "Eighteen");
        numbers.put(19, "Nineteen");
        numbers.put(20, "Twenty");
        numbers.put(30, "Thirty");
        numbers.put(40, "Forty");
        numbers.put(50, "Fifty");
        numbers.put(60, "Sixty");
        numbers.put(70, "Seventy");
        numbers.put(80, "Eighty");
        numbers.put(90, "Ninety");
        numbers.put(100, "Hundred");
        numbers.put(1000, "Thousand");
        //  numbers.put(100000, "Lakh");
        numbers.put(1000000, "Million");
        numbers.put(100000000, "Billion");
    }


    StringBuilder getNumberInWords(int number) throws InvalidNumberException {
        Map<Integer, String> numberMap = new TreeMap<>((o1, o2) -> o2 - o1);//or Comparator.reverseOrder()
        numberMap.put(0, "Zero");
        numberMap.put(1, "One");
        numberMap.put(2, "Two");
        numberMap.put(3, "Three");
        numberMap.put(4, "Four");
        numberMap.put(5, "Five");
        numberMap.put(6, "Six");
        numberMap.put(7, "Seven");
        numberMap.put(8, "Eight");
        numberMap.put(9, "Nine");
        numberMap.put(10, "Ten");
        numberMap.put(11, "Eleven");
        numberMap.put(12, "Twelve");
        numberMap.put(13, "Thirteen");
        numberMap.put(14, "Fourteen");
        numberMap.put(15, "Fifteen");
        numberMap.put(16, "Sixteen");
        numberMap.put(17, "Seventeen");
        numberMap.put(18, "Eighteen");
        numberMap.put(19, "Nineteen");
        numberMap.put(20, "Twenty");
        numberMap.put(30, "Thirty");
        numberMap.put(40, "Forty");
        numberMap.put(50, "Fifty");
        numberMap.put(60, "Sixty");
        numberMap.put(70, "Seventy");
        numberMap.put(80, "Eighty");
        numberMap.put(90, "Ninety");
        numberMap.put(100, "Hundred");
        numberMap.put(1000, "Thousand");
        numberMap.put(1000000, "Million");
        numberMap.put(1000000000, "Billion");

        if (number < 0) {
            throw new InvalidNumberException("Negative Number Not Allowed");
        }
        StringBuilder word = new StringBuilder();
        for (Integer n : numberMap.keySet()) {
            if (number > 0 && number >= n) {
                int div = number / n;
                String strNum = numberMap.get(div);
                if (strNum == null) {
                    word.append(getNumberInWords(div));
                }
                // for less than 100, we don't need to say 1
                if (strNum != null && (div > 1 || n > 100))
                    word.append(strNum + " ");

                word.append(numberMap.get(n) + " ");
                number = number % n;
            }
        }

        return word;
    }

    static String filterWord(StringBuilder word){
        String sourceWord = "Hundred";
        String targetWord= "Hundred and";
        int index=word.lastIndexOf(sourceWord);

        if(index!=-1 && word.toString().charAt(word.toString().length()-8)!='H') {
            word.replace(index, sourceWord.length() + index, targetWord);
        }
        return word.toString();
    }

    public static void main(String[] args) throws InvalidNumberException {
        NumberToWord numberToWord = new NumberToWord();
     //   System.out.println(numberToWord.getNumberInWords(1099921));
     //   System.out.println(numberToWord.getNumberInWords(1099900));

      //  System.out.println(numberToWord.getNumberInWord(10000));
        StringBuilder builder = numberToWord.getNumberInWords(1000099990);
        System.out.println(filterWord(builder).toString());



    }
}

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}
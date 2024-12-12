package com.app.test.hackerrank;

import java.util.Arrays;
import java.util.stream.Collectors;

/*

For a given sentence p, return the following:

how many vowels and consonants p has, we do not count Y and W as vowels
p with reversed words order and reversed cases (any upper-case letter will be lower-case and every lower-case letter will be upper-case)
every word in p separated by a dash ('-')
p with inserted string "pv" before any vowel in the sentence
Take into consideration that p can have any kind of characters.

You have to return a string containing the above queries, separated by double colon ("::")

INPUT
string    p

OUTPUT
string    combined_queries

This is how combined_queries should look like:
nr_vowels nr_consonants::reversed_p_with_reversed_cases::every-word-in-p::p_wpvith_inspvertpved_strpving_pv

EXAMPLE
Input
"ThIs is p"

Output
2 5::P IS tHiS::ThIs-is-p::ThpvIs pvis p

Input:
string p: "The iterator is just clutter"
Output:
Expected:
9 15::CLUTTER JUST IS ITERATOR tHE::The-iterator-is-just-clutter::Thpve pvitpverpvatpvor pvis jpvust clpvuttpver

Input:
string p: "Here is another p"
Output:
Expected:
6 8::P ANOTHER IS hERE::Here-is-another-p::Hpverpve pvis pvanpvothpver p

Input:
string p: "oaia oie o iii"
Output:
Expected:
11 0::III O OIE OAIA::oaia-oie-o-iii::pvopvapvipva pvopvipve pvo pvipvipvi
 */
public class StringManipulation {
    static final String VOWELS = "AEIOUaeiou";
    public static void main(String[] args) {
        String input = "ThIs is p";
        String result = combinedQueries(input);
        System.out.println(result);
    }

    public static String combinedQueries(String p) {
        int vowelsCount = countVowels(p);
        int consonantsCount = countConsonants(p);
        String reversedPWithReversedCases = reverseSentence(reverseWordsWithCases(p));
        String everyWordInP = separateWordsByDash(p);
        String pWithInsertedPV = insertPVBeforeVowels(p);

        return String.format("%d %d::%s::%s::%s", vowelsCount, consonantsCount,
                reversedPWithReversedCases, everyWordInP, pWithInsertedPV);
    }

    public static String reverseSentence(String sentence) {
        String[] words = sentence.split("\\s+");
        return Arrays.stream(words)
                .reduce((word1, word2) -> word2 + " " + word1)
                .orElse("");
    }

    private static int countVowels(String p) {
        return (int) p.chars()
                .filter(c -> {

                    return VOWELS.indexOf(c) != -1 && c != 'Y' && c != 'y' && c != 'W' && c != 'w';
                })
                .count();
    }

    private static int countConsonants(String p) {
        return (int) p.chars()
                .filter(c -> Character.isLetter(c) && VOWELS.indexOf(c) == -1 && c != 'Y' && c != 'y' && c != 'W' && c != 'w')
                .count();
    }

    private static String reverseWordsWithCases(String p) {
        return Arrays.stream(p.split("\\s"))
                .map(StringManipulation::reverseCase)
                .collect(Collectors.joining(" "));
    }

    private static String separateWordsByDash(String p) {
        return p.replaceAll("\\s", "-");
    }

    private static String insertPVBeforeVowels(String p) {
        return p.chars()
                .mapToObj(c -> {
                    if (VOWELS.indexOf(c) != -1 && c != 'Y' && c != 'y' && c != 'W' && c != 'w') {
                        return "pv" + (char) c;
                    }
                    return String.valueOf((char) c);
                })
                .collect(Collectors.joining(""));
    }

    private static String reverseCase(String word) {
        return new StringBuilder(word).chars()
                .mapToObj(c -> Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}


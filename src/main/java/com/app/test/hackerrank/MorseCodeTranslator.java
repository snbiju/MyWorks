package com.app.test.hackerrank;

import java.util.HashMap;
import java.util.Map;

/*

Today's challenge is about English.
We want you to write a program that converts Morse code to English text and English text to Morse code.
You can choose your favorite programming language to solve the challenge.

As a rule, for every Morse sentence, we should consider a space between morse letters,
and three spaces between morse words (" " => "   ") (also two spaces in english are equivalent to six spaces in morse ).

If the morse code that is going to be translated is not valid or the spacing is not correct,
you should output 'Invalid Morse Code Or Spacing'.

INPUT
boolean    morseToEnglish
^^ true if the given input text is in morse and false if it is in english

string    textToTranslate
^^ a string containing the text we wish to translate

OUTPUT
string    translatedText
^^ a string containing the input text, translated
INPUT
boolean    morseToEnglish
^^ true if the given input text is in morse and false if it is in english

string    textToTranslate
^^ a string containing the text we wish to translate

OUTPUT
string    translatedText
^^ a string containing the input text, translated

EXAMPLE
Input
false,"The wizard quickly jinxed the gnomes before they vaporized."

Output
- …. . .-- .. --.. .- .-. -.. --.- ..- .. -.-. -.- .-.. -.-- .--- .. -. -..- . -.. - …. . --. -. --- -- . … -… . ..-. --- .-. . - …. . -.-- …- .- .--. --- .-. .. --.. . -.. .-.-.-
- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.. -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -... . ..-. --- .-.    - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. .-
CONSTRAINTS
0 < nrCharacters <= 100 000
 */
public class MorseCodeTranslator {

    public static void main(String[] args) {
        boolean morseToEnglish = true;
        String textToTranslate = "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.. -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -... . ..-. --- .-.    - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. .-";
        String translatedText = translate(morseToEnglish, textToTranslate);
        System.out.println(translatedText);
    }

    public static String translate(boolean morseToEnglish, String textToTranslate) {
        if (morseToEnglish) {
            return stringToEnglish(textToTranslate);
        } else {
            return stringToMorse(textToTranslate);
        }
    }
    public static String stringToMorse( String text )
    {

        String newText = "";
        String selectedChar;
        String convertedChar;
        for (int i = 0; i < text.length(); i++)
        {

            //Select the next character
            selectedChar = text.charAt(i) + "";

            // Convert the character
            convertedChar = encode(selectedChar);

            if (convertedChar.equals(" ")) // " " separates each word represented in english code
            {
                newText = newText + "| ";
            }
            // Add the converted text, and add a space
            else
            {
                newText = newText + convertedChar;
                if (!convertedChar.equals(" "))
                {
                    newText = newText + " ";
                }
            }
        }

        return newText;
    }

    public static String stringToEnglish( String text )
    {
        String newEnglish = ""; //sets string for newEnglish
        StringBuilder builder = new StringBuilder();
        String selectedEnglish; //sets string for selectedEnglish
        String convertedEnglish; //sets string for convertedEnglish
        String[] morseChars = text.split(" ");
        for (int i = 0; i < morseChars.length; i++)
        {
            //Select the next Morse character
            selectedEnglish = morseChars[i];
            boolean endsWithWordSeparator = selectedEnglish.endsWith("|");
            if(endsWithWordSeparator) selectedEnglish = selectedEnglish.substring(0, selectedEnglish.length() - 1);
            // Convert the string
            convertedEnglish = decode(selectedEnglish);

            builder = builder.append(convertedEnglish);
            if (endsWithWordSeparator)
            {
                builder.append(" ");

            }
        }

        return builder.toString();
    }
    public static String encode (String toEncode)
    {
        String morse = toEncode;

        if (toEncode.equalsIgnoreCase("a"))
            morse = ".-";
        if (toEncode.equalsIgnoreCase("b"))
            morse = "-...";
        if (toEncode.equalsIgnoreCase("c"))
            morse = "-.-.";
        if (toEncode.equalsIgnoreCase("d"))
            morse = "-..";
        if (toEncode.equalsIgnoreCase("e"))
            morse = ".";
        if (toEncode.equalsIgnoreCase("f"))
            morse = "..-.";
        if (toEncode.equalsIgnoreCase("g"))
            morse = "--.";
        if (toEncode.equalsIgnoreCase("h"))
            morse = "....";
        if (toEncode.equalsIgnoreCase("i"))
            morse = "..";
        if (toEncode.equalsIgnoreCase("j"))
            morse = ".---";
        if (toEncode.equalsIgnoreCase("k"))
            morse = "-.-";
        if (toEncode.equalsIgnoreCase("l"))
            morse = ".-..";
        if (toEncode.equalsIgnoreCase("m"))
            morse = "--";
        if (toEncode.equalsIgnoreCase("n"))
            morse = "-.";
        if (toEncode.equalsIgnoreCase("o"))
            morse = "---";
        if (toEncode.equalsIgnoreCase("p"))
            morse = ".--.";
        if (toEncode.equalsIgnoreCase("q"))
            morse = "--.-";
        if (toEncode.equalsIgnoreCase("r"))
            morse = ".-.";
        if (toEncode.equalsIgnoreCase("s"))
            morse = "...";
        if (toEncode.equalsIgnoreCase("t"))
            morse = "-";
        if (toEncode.equalsIgnoreCase("u"))
            morse = "..-";
        if (toEncode.equalsIgnoreCase("v"))
            morse = "...-";
        if (toEncode.equalsIgnoreCase("w"))
            morse = ".--";
        if (toEncode.equalsIgnoreCase("x"))
            morse = "-..-";
        if (toEncode.equalsIgnoreCase("y"))
            morse = "-.--";
        if (toEncode.equalsIgnoreCase("z"))
            morse = "--..";
        if (toEncode.equalsIgnoreCase("0"))
            morse = "-----";
        if (toEncode.equalsIgnoreCase("1"))
            morse = ".----";
        if (toEncode.equalsIgnoreCase("2"))
            morse = "..---";
        if (toEncode.equalsIgnoreCase("3"))
            morse = "...--";
        if (toEncode.equalsIgnoreCase("4"))
            morse = "....-";
        if (toEncode.equalsIgnoreCase("5"))
            morse = ".....";
        if (toEncode.equalsIgnoreCase("6"))
            morse = "-....";
        if (toEncode.equalsIgnoreCase("7"))
            morse = "--...";
        if (toEncode.equalsIgnoreCase("8"))
            morse = "---..";
        if (toEncode.equalsIgnoreCase("9"))
            morse = "----.";
        if (toEncode.equalsIgnoreCase("."))
            morse = ".-.-";
        if (toEncode.equalsIgnoreCase(","))
            morse = "--..--";
        if (toEncode.equalsIgnoreCase("?"))
            morse = "..--..";

        return morse;
    }

    public static String decode (String toEncode) {
        String morse = toEncode;

        if (toEncode.equalsIgnoreCase(".-"))
            morse = "a";
        if (toEncode.equalsIgnoreCase("-..."))
            morse = "b";
        if (toEncode.equalsIgnoreCase("-.-."))
            morse = "c";
        if (toEncode.equalsIgnoreCase("-.."))
            morse = "d";
        if (toEncode.equalsIgnoreCase("."))
            morse = "e";
        if (toEncode.equalsIgnoreCase("..-."))
            morse = "f";
        if (toEncode.equalsIgnoreCase("--."))
            morse = "g";
        if (toEncode.equalsIgnoreCase("...."))
            morse = "h";
        if (toEncode.equalsIgnoreCase(".."))
            morse = "i";
        if (toEncode.equalsIgnoreCase(".---"))
            morse = "j";
        if (toEncode.equalsIgnoreCase("-.-"))
            morse = "k";
        if (toEncode.equalsIgnoreCase(".-.."))
            morse = "l";
        if (toEncode.equalsIgnoreCase("--"))
            morse = "m";
        if (toEncode.equalsIgnoreCase("-."))
            morse = "n";
        if (toEncode.equalsIgnoreCase("---"))
            morse = "o";
        if (toEncode.equalsIgnoreCase(".--."))
            morse = "p";
        if (toEncode.equalsIgnoreCase("--.-"))
            morse = "q";
        if (toEncode.equalsIgnoreCase(".-."))
            morse = "r";
        if (toEncode.equalsIgnoreCase("..."))
            morse = "s";
        if (toEncode.equalsIgnoreCase("-"))
            morse = "t";
        if (toEncode.equalsIgnoreCase("..-"))
            morse = "u";
        if (toEncode.equalsIgnoreCase("...-"))
            morse = "v";
        if (toEncode.equalsIgnoreCase(".--"))
            morse = "w";
        if (toEncode.equalsIgnoreCase("-..-"))
            morse = "x";
        if (toEncode.equalsIgnoreCase("-.--"))
            morse = "y";
        if (toEncode.equalsIgnoreCase("--.."))
            morse = "z";
        if (toEncode.equalsIgnoreCase("-----"))
            morse = "0";
        if (toEncode.equalsIgnoreCase(".----"))
            morse = "1";
        if (toEncode.equalsIgnoreCase("..---"))
            morse = "2";
        if (toEncode.equalsIgnoreCase("...--"))
            morse = "3";
        if (toEncode.equalsIgnoreCase("....-"))
            morse = "4";
        if (toEncode.equalsIgnoreCase("....."))
            morse = "5";
        if (toEncode.equalsIgnoreCase("-...."))
            morse = "6";
        if (toEncode.equalsIgnoreCase("--..."))
            morse = "7";
        if (toEncode.equalsIgnoreCase("---.."))
            morse = "8";
        if (toEncode.equalsIgnoreCase("----."))
            morse = "9";
        if (toEncode.equalsIgnoreCase("|"))
            morse = " ";

        return morse;
    }



}


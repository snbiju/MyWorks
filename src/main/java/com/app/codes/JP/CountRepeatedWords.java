package com.app.codes.JP;

import java.util.HashMap;
import java.util.Map;

public class CountRepeatedWords {
    public static Map<String ,Integer> getCount(String sentence){
        String [] words= sentence.split(" ");
        Map<String,Integer> wordCounter = new HashMap<>();
        for (String word:words
             ) {
                 if(wordCounter.containsKey(word.toLowerCase())) {
                    wordCounter.put(word.toLowerCase(), wordCounter.get(word.toLowerCase())+1);
                 } else
                     wordCounter.put(word.toLowerCase(),1);
                 }

        return wordCounter;
    }
    public static void main(String[] args) {
        String  sentences = "JAVA test program java test PROGRAM pRoGraM";
        System.out.println(getCount(sentences));


    }
}

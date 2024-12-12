package com.app.codes.ubs;

import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*

. In this challenge you will be given an array of sentences and an array of queries,
 Determine which sentences contain all the  words the answer to that query is [-1].

    example
    sentence =["bob and alice like to text each other", bob does not like to ski but does not like to fall","Alice likes to ski"]
    queries =['bob alice','alice','like','non occurrence']

    the result of the queries are

    0. sentences[0]-> [0]
    1. sentences[0] ->[0]
    2. sentences[0],sentences[1],sentences[1]->[0,1,1]
    3. none match ->[-1]

    Return a 2-dimensional integer array:[[0],[0],[0,1,1],[-1]].


    input
    sentences=["jim likes mary","kate likes tom","tom does not like jim"]
    query = ["jim tom","likes"]

    output [[2],[0,1]]



 */

public class TextQueries {
public static final Logger logger= Logger.getLogger("TextQueries.class");
    public static List<List<Integer>> textsQueries(List<String> sentences, List<String> queries) {
        List<List<Integer>> results = new ArrayList<>();

        for (String query : queries) {
            List<Integer> indexes = new ArrayList<>();
            for (String sentence : sentences) {
                Map<String, Integer> wordMap = new HashMap<>();
                String[] words = query.split("\\s");

                // Count occurrences of each word in the sentence
                for (String word : words) {
                    Pattern pattern = Pattern.compile("\\b(?:" + word + ")\\b", Pattern.UNICODE_CASE);
                    int matchCount = countMatches(pattern, sentence);
                    wordMap.put(word, matchCount);
                }

                // Find the minimum occurrence count
                int min = Collections.min(wordMap.values());

                if (min > 0) {
                    // Add sentence index to indexes for each occurrence
                    for (int i = 1; i <= min; i++) {
                        indexes.add(sentences.indexOf(sentence));
                    }
                }
            }

            if (indexes.isEmpty()) {
                indexes.add(-1);
            }

            results.add(indexes);
        }

        return results;
    }

    static int countMatches(Pattern pattern, String string) {
        Matcher matcher = pattern.matcher(string);

        int count = 0;
        int pos = 0;
        while (matcher.find(pos)) {
            count++;
            pos = matcher.start() + 1;
        }
        return count;
    }


    public static void main(String[] args) {

        List<String> sentences = List.of("bob and alice like to text each other", "bob does not like to ski but does not like to fall","Alice likes to ski");
        List<String> queries=List.of("bob alice","alice","like","non occurrence");

        List<String> sentences1=List.of("jim likes mary","kate likes tom","tom does not like jim");
        List<String> query = List.of("jim tom","likes");

        logger.info(textsQueries(sentences,queries).toString());

        logger.info(textsQueries(sentences1,query).toString());

    }
}

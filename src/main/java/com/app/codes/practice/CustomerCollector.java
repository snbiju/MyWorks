package com.app.codes.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class CustomerCollector {


    public static void main(String args[])
    {
        Collector<String, ?, String> joiningWithDelimiter = Collector.of(
                StringBuilder::new, // supplier
                (sb, str) -> sb.append(str).append(","), // accumulator
                StringBuilder::append, // combiner
                StringBuilder::toString // finisher
        );

        List<String> strings = Arrays.asList("Java", "Streams", "API");
        String result = strings.stream().collect(joiningWithDelimiter);
        System.out.println(result); // Outputs: Java,Streams,API,

    }
}

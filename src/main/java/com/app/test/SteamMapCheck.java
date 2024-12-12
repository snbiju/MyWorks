package com.app.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamMapCheck {

    public static void main(String[] args) {
        String[] arrayOfWords = {"STACK", "OOOVVVER"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
        List<String> mylist = streamOfWords.map(s -> s.split("")) //Converting word in to array of letters
                .flatMap(Arrays::stream).distinct() //flattens each generated stream in to a single stream
                .collect(Collectors.toList());

        System.out.println(mylist);

        // String[] arrayOfWords = {"STACK", "OOOVVVER"};
        streamOfWords = Arrays.stream(arrayOfWords);
        List<Stream> mapList = streamOfWords.map(s -> s.split("")) //Converting word in to array of letters
                .map(Arrays::stream).distinct() //Make array in to separate stream
                .collect(Collectors.toList());


        System.out.println(mapList);


        Parcel amazon = new Parcel("amazon", "Laptop", "Phone");
        Parcel ebay = new Parcel("ebay", "Mouse", "Keyboard");
        List<Parcel> parcels = Arrays.asList(amazon, ebay);

        System.out.println("-------- Without flatMap() ---------------------------");
        List<List<String>> mapReturn = parcels.stream()
                .map(Parcel::getItems)
                .collect(Collectors.toList());
        System.out.println("\t collect() returns: " + mapReturn);

        System.out.println("\n-------- With flatMap() ------------------------------");
        List<String> flatMapReturn = parcels.stream()
                .map(Parcel::getItems)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("\t collect() returns: " + flatMapReturn);
    }

    static class Parcel {
        String name;
        List<String> items;

        public Parcel(String name, String... items) {
            this.name = name;
            this.items = Arrays.asList(items);
        }

        public List<String> getItems() {
            return items;
        }
    }
}

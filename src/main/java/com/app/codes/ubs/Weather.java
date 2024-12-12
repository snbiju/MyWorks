package com.app.codes.ubs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Weather {
    String place;
    Double temperature;
    public Weather(){}

    public Weather(String place, Double temperature) {
        this.place = place;
        this.temperature = temperature;
    }

    public String getPlace() {
        return place;
    }

    public Double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return new StringBuffer("place :" ).append(this.place).append("Temparature:").append(this.temperature).toString();
    }

    public static void main(String[] args) {
        List<Weather> weathers = new ArrayList<>();
        weathers.add(new Weather("Sunny",33.0));
        weathers.add(new Weather("Rainy",17.0));
        weathers.add(new Weather("Cloudty",23.0));
        weathers.add(new Weather("Cold",3.0));
        weathers.add(new Weather("Hot",37.0));
        weathers.add(new Weather("Windy",13.0));
        weathers.add(new Weather("Snowy",0.0));
        weathers.add(new Weather("Freezing",-15.00));

        List<Weather> sortedWeathers = weathers.stream()
                .sorted(Comparator.comparingDouble(Weather::getTemperature))
                .collect(Collectors.toList());

        // Print the sorted list
      //  sortedWeathers.forEach(System.out::println);

       // weathers.stream().sorted(Weather::getTemperature).forEach(System.out::println);
        weathers.stream().map(Weather::getTemperature).sorted().forEach(System.out::println);


        weathers.stream().map(Weather:: getTemperature).sorted().forEach(System.out:: println);
       // weathers.stream().sorted(Weather:: getTemperature).forEach(System.out:: println);
       // weathers.stream().sorted(p1,p2)->p1.getTemperature().compareTo(p2.getTemperature())).forEach(System.out:: println);
      //  weathers.stream().map(Weather::getTemperature).sorted(p1,p2)->p1.compareTo(p2)).forEach(System.out:: println);




    }
}

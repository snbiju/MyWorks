package com.app.test;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Collectors;

public class Haversine {

    static List<Shops> shopeList;
    static double haversine(double lat1, double lon1,
                            double lat2, double lon2)
    {
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);

        //to search by KM instead of Mile, replace `3959` with `6371`.
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }

    //distnce

    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {

            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }


    //Example 3
    public static double getDistanceBetweenPointsNew(double latitude1, double longitude1, double latitude2, double longitude2, String unit) {
        double theta = longitude1 - longitude2;
        double distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
                Math.sin(latitude1 * (Math.PI/180)) * Math.sin(latitude2 * (Math.PI/180)) +
                        Math.cos(latitude1 * (Math.PI/180)) * Math.cos(latitude2 * (Math.PI/180)) * Math.cos(theta * (Math.PI/180))
        );
        if (unit.equals("miles")) {
            return Math.round(distance);
        } else if (unit.equals("kilometers")) {
            return Math.round(distance * 1.609344);
        } else {
            return 0;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        shopeList = new ArrayList<>();
        dataAdded();
        double lat1 = 51.5007;
        double lon1 = 0.1246;
        double latitu1= Math.asin(Math.sin(lat1)*Math.cos(25)+Math.cos(lat1)*Math.sin(25)*Math.cos(Math.toRadians(lat1)));
        if(Math.cos(latitu1)==0){
            latitu1=lat1;
        }else {
            double fl= Math.sin(Math.toRadians(lat1)*Math.sin(25)/Math.cos(latitu1));

       //     latitu1= Math.floorMod(lon1-Math.asin((long)fl))+3.14,2*(long)Math.PI)-Math.PI;
        }

     /*   lat=asin(sin(lat1)*cos(d)+cos(lat1)*sin(d)*cos(tc))
        IF (cos(lat)=0)
        lon=lon1      // endpoint a pole
        ELSE
                lon=mod(lon1-asin(sin(tc)*sin(d)/cos(lat))+pi,2*pi)-pi
        ENDIF
*/

// Latitude
        double earth = 6378.137;  //radius of the earth in kilometer
        double newLatitude = newLatitude(lat1, earth);
        //Longitude

        System.out.println("Given Latitude:"+lat1 +"Given Longitude:"+lon1);
        System.out.println("New Latitude:"+newLatitude);


        System.out.println("Given Latitude:"+lat1 +"Given Longitude:"+lon1);
        double newLongitude= newLongitude(lat1, lon1, earth);
        System.out.println("New Logitude :"+newLongitude);

        final long dist = Math.round(haversine(lat1, lon1, newLatitude, lon1));
        System.out.println("Distance between new coordinate: "+ dist);
       Map<Shops,Double> shopsMap = shopeList.stream()
               .collect(Collectors.toMap(x->x, x->haversine(x.lat,x.log,newLatitude,newLongitude)))
              .entrySet().stream().filter(e->e.getValue()<=50)
              .collect(Collectors.toMap(x->x.getKey(),x->x.getValue()));

      List<Shops> list1= shopeList.stream()
                .collect(Collectors.toMap(x->x, x->haversine(x.lat,x.log,newLatitude,newLongitude)))
                .entrySet().stream().filter(e->e.getValue()<=50)
                       .map(Map.Entry::getKey).collect(Collectors.toList());


        for (Shops shop:list1
             ) {
            System.out.println("From List Shope Latitude:"+shop.getLat() +" and Shop Longitude:"+shop.getLog());

        }

        Map<Shops,Double> shopsMap1=  shopsMap.entrySet()
                .stream().filter(x->x.getValue() > 25)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));



        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("One", 1);
        myMap.put("Two", 2);
        myMap.put("Three", 3);

        myMap.keySet().removeAll(
                myMap.entrySet().stream()
                        .filter(a->a.getValue().equals(2))
                        .map(e -> e.getKey()).collect(Collectors.toList()));

        System.out.println(myMap);

        //List<Shops> listShops=shopeList.stream().filter(x->x.log<=newLongitude && x.lat<=newLatitude).collect(Collectors.toList());
    //    List<Shops> listShops = shopeList.stream().filter(x->haversine(x.lat,x.log,newLatitude,newLongitude)<=25).collect(Collectors.toList());
        for (Map.Entry<Shops,Double> s:shopsMap.entrySet()
        ) {
            System.out.println("Shope Latitude:"+s.getKey().lat +" and Shop Longitude:"+s.getKey().log + " : Distance - "+s.getValue());
           // System.out.println(haversine(s.lat, s.log, lat4, lon4) + " K.M.");
        }

        double lat2 = 40.6892;
        double lon2 = 74.0445;
      //  System.out.println(haversine(lat1, lon1, lat2, lon2) + " K.M.");

        double lat3 = 40.712448;
        double lon3 = -74.006653;
        double lat4 = 40.754150;
        double lon4 = -74.001114;
      //  System.out.println(haversine(lat3, lon3, lat4, lon4) + " K.M.");




        for (Shops s:shopeList
             ) {
         //   System.out.println("From Latitude:"+s.lat +"To Latitude:"+lat4+" and From Longitude:"+s.log+" To Logitude:"+lon4);
          //  System.out.println(haversine(s.lat, s.log, lat4, lon4) + " K.M.");
        }

        for (Shops x : shopeList) haversine(x.lat, x.log, lat4, lon4);
    //    shopeList.stream().map(x->haversine(x.lat, x.log, lat4, lon4)).collect(Collectors.toList()).stream().filter(s->s.doubleValue()<5).forEach(System.out::println);

       // shopeList.stream().map(x->haversine(x.lat, x.log, lat4, lon4)).collect(Collectors.toMap())

    //    Map<Object, Object> map= shopeList.stream().collect(Collectors.toMap(x->x, x->haversine(x.lat,x.log,lat4,lon4))).;

        List<Shops> shops= shopeList.stream().collect(Collectors.toMap(x->x, x->haversine(x.lat,x.log,lat4,lon4))).entrySet()
                .stream().filter(x->x.getValue()<5).collect(Collectors.toList())
                .stream().map(x->x.getKey()).collect(Collectors.toList());
        for (Shops shop:shops
             ) {
           // System.out.println(shop.name);
        }




    }

    private static void dataAdded() {
        Shops shop1 = new Shops("M&S1","London",51.5007,0.1246);
        Shops shop2 = new Shops("M&S2","London",51.5107,0.2246);
        Shops shop3 = new Shops("M&S3","London",51.5207,0.3346);
        Shops shop4 = new Shops("M&S4","London",51.5107,0.1536);
        Shops shop5 = new Shops("M&S6","London",51.5227,0.1346);
        Shops shop6 = new Shops("M&S7","London",51.5307,0.1256);
        Shops shop7 = new Shops("M&S8","London",51.5507,0.1676);
        Shops shop8 = new Shops("M&S9","London",51.5077,0.1261);


        shopeList.add(shop1);
        shopeList.add(shop2);
        shopeList.add(shop3);
        shopeList.add(shop4);
        shopeList.add(shop5);
        shopeList.add(shop6);
        shopeList.add(shop7);
        shopeList.add(shop8);


        Shops shopp1 = new Shops("M&N1","Manchester",40.754150,-74.006653);
        Shops shopp2 = new Shops("M&N2","Manchester",40.764150,-74.001114);
        Shops shopp3 = new Shops("M&N3","Manchester",40.762448,-74.007653);
        Shops shopp4 = new Shops("M&N4","Manchester",40.812448,-74.026653);
        Shops shopp5 = new Shops("M&N5","Manchester",40.712448,-74.076653);
        Shops shopp6 = new Shops("M&N7","Manchester",40.112448,-74.026053);
        Shops shopp7 = new Shops("M&N8","Manchester",40.712448,-74.006693);
        Shops shopp8 = new Shops("M&N9","Manchester",40.712448,-74.006453);

        shopeList.add(shopp1);
        shopeList.add(shopp2);
        shopeList.add(shopp3);
        shopeList.add(shopp4);
        shopeList.add(shopp5);
        shopeList.add(shopp6);
        shopeList.add(shopp7);
        shopeList.add(shopp8);
    }

    private static double newLatitude(double lat1, double earth) {
        double m = (1 / ((2 * Math.PI / 360) * earth));  //1 meter in degree

        double new_latitude = lat1 + (25 * m);
        return new_latitude;
    }

    private static double newLongitude(double lat1, double lon1, double earth) {
        //  double earth = 6378.137,  //radius of the earth in kilometer
        double  m = (1 / ((2 * Math.PI / 360) * earth)) ;  //1 meter in degree
        double new_longitude = lon1 + (25 * m) / Math.cos(lat1 * (Math.PI / 180));
        return new_longitude;
    }
}


class Shops {
    String name;
    String place;
    double lat;
    double log;

    public Shops(String name, String place, double lat, double log) {
        this.name = name;
        this.place = place;
        this.lat = lat;
        this.log = log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLog() {
        return log;
    }

    public void setLog(double log) {
        this.log = log;
    }
}
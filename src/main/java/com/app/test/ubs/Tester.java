package com.app.test.ubs;


import java.io.IOException;

class Airplane{
    Airplane() throws IOException {
        System.out.println("Air Plane");
        throw  new IOException();

    }
}
class AirJet extends Airplane{
  AirJet() throws IOException {
      System.out.println("AirJet");
    /*  try{
      // super();
      }catch (IOException io){
          System.out.println("IO Exception throws in Airjet");
      }*/
  }
}
public class Tester {
    //A a = (String s)->1
}

interface  Test{
    int aMethod(String s);
}

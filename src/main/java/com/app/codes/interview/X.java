package com.app.codes.interview;

public class X {
    public static void main(String[] args) {
        try{
            badMethod();
            System.out.println("A");
        }catch (Exception e){
            System.out.println("B");
        }
        finally {
            System.out.println("C");
        }
        System.out.println("D");
    }
     public static void badMethod(){}
}

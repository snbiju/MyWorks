package com.app.codes.ubs;

public class X {


    public static void main(String[] args) {
        try{
            badMthod();
            System.out.print("A");
        }catch (Exception e){
            System.out.print("B");
        }finally {
            System.out.print("C");
        }
        System.out.print("D");
    }
    public static void badMthod(){}
}

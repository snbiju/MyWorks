package com.app.codes;

import java.util.Scanner;

public class ModuloDiv {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int N= scanner.nextInt();
        if(N%2==0){
            if(N>5 && N<20){
                System.out.print("Not Weird");
            }else{
                System.out.print("Weird");
            }
        }else{
            System.out.print("Weird");
        }
        scanner.close();

    }
}

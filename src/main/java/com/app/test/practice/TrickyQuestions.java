package com.app.test.practice;

public class TrickyQuestions {

    public static void main(String[] args) {

           // int i = 0;

          //  System.out.println(i++ + ++i);

         //   int a = 5;
          //  int b = 10;

         //   System.out.println(a++ + ++b);


        int a = 5;
        int b = 10;
        a ^= b ^= a ^= b;
        System.out.println(a + "-" + b);


        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    System.out.print("A");
                case 1:
                    System.out.print("B");
                   break;
                case 2:
                    System.out.print("C");
            }
        }


    }
}

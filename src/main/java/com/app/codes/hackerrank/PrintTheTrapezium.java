package com.app.codes.hackerrank;

import java.util.Scanner;

/*
Problem Statement -: Anirudh is attending an astronomy lecture. His professor who is very strict asks students to write
a program to print the trapezium pattern using stars and dots as shown below . Since Anirudh is not good in astronomy
can you help him?



Sample Input:

N = 3

Output:

**.**

*…*

…..

*…*

**.**
 */
public class PrintTheTrapezium {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i,j;
        for(i=0;i< n;i++)
        {
            for(j=0;j< n;j++)
            {
                if(j< n-i-1)
                    System.out.print("*");
                else
                    System.out.print(".");
            }
            for(j=0;j< n-1;j++)
            {
                if(j< i)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }

        for(i=2;i<=n;i++)
        {
            for(j=0;j< n;j++)

            {
                if(j< i-1)
                    System.out.print("*");
                else
                    System.out.print(".");

            }
            for(j=0;j< n-1;j++)
            {
                if(j< n-i)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}

package com.app.test.hackerrank;
/*
Problem Statement – Rohan is weak in mathematics.He is giving mathematics  Olympiad , but he got stuck in one of the question. Help rohan to solve the question.In Question there are two positive integer A and B. You have to find the product of all integer between A and B which is represented in the form C=D*10^E , where  C is the product of numbers , D and E are non-negative integers and the last digit of D is non-zero.

Function Description

Complete the function formatProducts in the editor below, formatProduct must return a string that represents C in the above described form.

Function has the following parameters

A: an integer
B: an integer
Constraints :

   A will between 1 and 1,000,000 . Inclusive.
   B will be between A and 1,000,000. Inclusive.
Sample Input :

1

5

Sample Output :

12 * 10^1

Explanation :

1*2*3*4*5=120 = 12 * 10^1

 Sample Input :

3

10

Sample Output :

18144 * 10^2

Explanation :

3*4*….*10=1814400 =18144 * 10^2
 */
import java.util.*;
public class FormattingProducts
{
    public static String formatProducts(int a,int b)
    {
        int result=1;
        for(int i=a;i<=b;i++)
            result=result*i;
        int temp=result;
        int power=0;
        while((result%10)==0)
        {
            power=power+1;
            result=result/10;
        }
        return result +" * 10^"+power;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(formatProducts(a,b));
    }
}
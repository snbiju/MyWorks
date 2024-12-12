package com.app.test.hackerrank;

/*

Problem Statement – A teacher wants to look at students’ attendance data. Given that there is a class ,
and the teacher has the record of the students present on n days of the month, find the maximum number of
consecutive days on which all students were present in the class.

Example

m=4
n=7
data=[PPPP, PPPP ,PPPP ,PPAP ,AAPP ,PAPA ,AAAA]

There are 4 students and 7 days attendance data . There are only three days, at the beginning where all students are present.
Student 3 is absent on the fourth day , and students 1 and 2 are absent on the fifth day , and students 2 and 4 are absent on the
sixth day and all are absent on the last day.

The maximum number of consecutive days on which all the students were present in the class is 3 days long.

Function Description :

Complete the maxConsecutive function in the editor below. The function must return an integer denoting the maximum number
 of consecutive days when all the students are present in the class.

int m : the number of students in the class.
string data[n] : the value of each element data[i] is a
string where data[i] denotes ith student is present on the ith day.
Constraints :

1<=m<=10
1<=n<=31
Each data[i][j]={‘P’,’A’}
Input Format :

3
4
PPP
PPA
AAP
AAA
Sample Output:
1

Explanation :
There is only one day in which all the students are present.
 */
import java.util.*;
class MaximumAttendance
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        String[] arr =new String[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.next();

        findAttendance(m, n, arr);
    }

    private static void findAttendance(int m, int n, String[] arr) {
        String present="";
        int j=0;
        while(j< m)
        {
            present=present +"P";
            j++;
        }
        int max=0;
        int count=0;
        for(int i = 0; i< n; i++)
        {
            if(arr[i].equals(present))
                count++;
            else
            {
                max=Math.max(max,count);
                count=0;
            }
        }

        System.out.println(max);
    }
}

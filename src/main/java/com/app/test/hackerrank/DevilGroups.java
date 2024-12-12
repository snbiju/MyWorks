package com.app.test.hackerrank;

import java.util.*;

/*

Problem Statement –

There are some groups of devils, and they split into people to kill them. Devils make People to them left as their group
and at last the group with maximum length will be killed. Two types of devils are there namely “@” and “$”
People is represented as a string “P”

Input Format:
First line with the string for input

Output Format:
Number of groups that can be formed.

Constraints:
2<=Length of string<=10^9

Input string
PPPPPP@PPP@PP$PP

Output
7

Explanation
4 groups can be formed

PPPPPP@
PPP@
PP$
PP
Most people in the group lie in group 1 with 7 members.
 */
class DevilGroups
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        devilGroup(str);
    }

    private static void devilGroup(String str) {
        str = str.replace("@"," ");
        str = str.replace("$"," ");
        String[] arr = str.split(" ");
        int max=0;
        for(int i=0;i<arr.length;i++)
            max=Math.max(max,arr[i].length());
        System.out.println(max);
    }

    public static int countPeopleToKill(String input){
        int a=0, ans=Integer.MAX_VALUE;
        for(int i=0;i<input.length();i++){
            a++;
            if(input.charAt(i)=='@' || input.charAt(i)== '$'){
                ans=Math.min(a,ans);
                a=0;
            }
        }
        ans= Math.min(a,ans);
        return ans;

    }
}
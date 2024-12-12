package com.app.codes.ubs;

import java.util.HashMap;
import java.util.Map;

/*
Erica nd Bob participate in a friendly hackaton that allows eah one to solve one questionb a day out of the thee offered. There will be ne easy one mediuym and one hard question, with points awared based on diffculty. The winner is the one with the highest score at the end of the competition based on the following scale

score table

-----------------------------------
- Difficulty.    ...  Points.   ..
-----------------------------------
- Easy(E).       ---       1    --
- Medium(M).     ---       3.   --
- High (H)       ---       5    --
------------------------------------


There are two strings, eria and bob. Each character erica[i]  and bob[i] represent the difficulties of the propblems ("E","M","H") solved on day[i] by Erica nd Bob. t/he scoring table associate the points for each question difficulty. Calculate te scores for Erica adn Bob. Return the name of the winner : "Erica", "Bob" or "Tie" if they have the same score.


Example
erica =["E"]
bob =["E"]

Day.   Erica's Difficulty.  Erica's Score.    Bob Difficulty.  Bob's Score

0.              E                        1                           E                   1


erica[0] = "E" . The first question sloved by Eria in day 0 was easy "E" and Eria's score is 1
bob[0] = "E" . The first question sloved by Bob in day 0 was easy "E" and Bob's score is 1
Erica's nd Bob's scores are equal : Tie

Functional description

Complete the funtion winner in the editor below

winner has the following parameter(s):
String erica[n]: erica[i] desnotes the difficulty of Erica's problem solved on day i
String bob[n]: bob[n]: bob[i] denotes the difficulty of Bob's problem solved on day i

Returns:
String winnerName: a name of the winner Erica or Bob or Tie if their score are equal.

Contrains
0<n<10^5

Input

erica =["E","H","H"]
bob =["E","M","E"]

output
Erica

 */
public class CoderFriends {

    public static String winner(String erica,String bob){

        int ericaPoint=0;
        int bobPoint =0;
        String result;

        String[] ericaScore =erica.split(",");
        String[] bobScore = bob.split(",");

        ericaPoint= findPoint(ericaScore);
        bobPoint= findPoint(bobScore);
        if(ericaPoint>bobPoint){
            result="Erica";
        }else if(ericaPoint<bobPoint){
            result="Bob";
        }else {
            result="Tie";
        }

        return result;
    }

    private static int findPoint(String[] scores) {
        Map<String,Integer> scoreMap = new HashMap<>();
        scoreMap.put("E",1);
        scoreMap.put("M",3);
        scoreMap.put("H",5);
        int points=0;
        for(String score: scores){
            if(scoreMap.containsKey(score)){
                points = points + scoreMap.get(score);
            }
        }
        return points;
    }

    public static void main(String[] args) {
       CoderFriends.winner("E,M,H","H,M,M");

    }
}

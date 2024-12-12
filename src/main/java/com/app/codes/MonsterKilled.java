package com.app.codes;

public class MonsterKilled {


    public static void main(String[] args) {
        String input = "PPPPPP@PPP@PPP$PPP@PPPPPPP$PPP@PP$P";
        System.out.println(input);
        System.out.println(countPeopleToKill(input));
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

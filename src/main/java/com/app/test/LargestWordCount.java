package com.app.test;
import java.util.*;

public class LargestWordCount {


    // you can also use imports, for example:


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

        public int solution(String S) {
            
            // write your code in Java SE 8
            System.out.println(S);
            Map<Character,Integer> map = new HashMap<>();
            for(int i=0;i<S.length();i++){
                char c = S.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            String [] sentances = S.split("\\.");
            System.out.println(sentances[0]);
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<sentances.length;i++){
                if(sentances[i].length()>0){
                    String[] words=sentances[i].split(" ");
                    System.out.println("split"+ Arrays.asList(words).stream().filter(s->s.isBlank()).count());
                    //set.add(sentances[i].split(" "));
                }


            }

            return Collections.max(set);
        }

    public static void main(String[] args) {
        LargestWordCount count = new LargestWordCount();
     //   count.solution("We test coders. Give us a try?");
        System.out.println(count.solution("Forget  CVs..Save time . x x"));
    }
    }

/*
We test coders. Give us a tr

We test coders. Give us a try?
Example test:   'Forget  CVs..Save time . x x'
Output:
Forget  CVs..Save time . x x
Forget  CVs
WRONG ANSWER (got 3 expected 2)
A B C D e f G hH II Jj
A B C D e f G hH II Jj
 */
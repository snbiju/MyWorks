package com.app.test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CandiesShare {

    public int candiShare(int [] T){

        int len = T.length;
        int half = len/2;
        int result=0;
        if(len==0 || len==1){
            return result;
        }

        Set<Integer> unique= IntStream.of(T).boxed().collect(Collectors.toSet());
        System.out.println("size:"+unique.size());
        result = Math.min(unique.size(), half);
        return result;
    }

    public static void main(String[] args) {
        CandiesShare candiesShare = new CandiesShare();
        System.out.println(candiesShare.candiShare(new int[]{3,4,7,7,6,6,5,8,9}));
        System.out.println(candiesShare.candiShare(new int[]{80,80,1000000000,80,80,80,80,80,80,123456789}));
    }
}

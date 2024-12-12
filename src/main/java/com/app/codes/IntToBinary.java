package com.app.codes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntToBinary {

    public int getValue(int N){

        String value = Integer.toBinaryString(N);
        List<Integer> listCount = new ArrayList<>();
        for(int i=0;i<value.length();i++){
            if(value.charAt(i)=='1') {
                listCount.add(i);
            }
            System.out.println("index of 1"+listCount );
        }
        if(listCount.size()==1){
            return value.length()-1;
        }
        List<Integer> count = new ArrayList<>();
        for (int ind=listCount.size();ind>0 ;ind--
             ) {
            if(ind>1) {
               count.add(listCount.get(ind-1) -listCount.get(ind-2));
            }

        }


        return Collections.max(count)-1;
    }
    public static void main(String[] args) {
        IntToBinary binary = new IntToBinary();
        System.out.println(binary.getValue(32));


    }
}

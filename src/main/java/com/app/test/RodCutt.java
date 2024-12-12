package com.app.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RodCutt {

    public List<Integer> rodOffCut(List<Integer> rods){
        Collections.sort(rods);
        List<Integer> result = new ArrayList<>();
        while (!rods.isEmpty()) {
            if(rods.get(0)==0){
                rods.remove(0);
            }
            result.add(rods.size());
            int index=rods.get(0);
            rods.remove(rods.remove(rods.indexOf(rods.get(0))));

            if(rods.size()>0) {
                for (int i = 0; i < rods.size(); i++
                ) {
                    rods.set(i, rods.get(i) - index);
                }
            }

        }

        return result;
    }

    public List<Integer> rodOffCut1(List<Integer> rods) {
        Collections.sort(rods);
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = rods.size() - 1;

        while (left <= right) {
            int length = rods.get(left);
            if (length == 0) {
                left++;
                continue;
            }

            result.add(right - left + 1);
            rods.remove(left);

            for (int i = left; i <= right; i++) {
                rods.set(i, rods.get(i) - length);
            }

            while (left <= right && rods.get(left) <= 0) {
                left++;
            }
        }

        return result;
    }

    public List<Integer> rodOffCut2(List<Integer> rods) {
        Collections.sort(rods);
        List<Integer> result = new ArrayList<>();
        int n = rods.size();

        for (int i = n - 1; i >= 0; i--) {
            if (rods.get(i) == 0) {
                rods.remove(i);
            }
        }

        int remaining = rods.size();
        result.add(remaining);

        for (int i = 0; i < n; i++) {
            int index = rods.get(0);
            rods.remove(0);

            if (!rods.isEmpty()) {
                for (int j = 0; j < rods.size(); j++) {
                    rods.set(j, rods.get(j) - index);
                }
                while (!rods.isEmpty() && rods.get(0) <= 0) {
                    rods.remove(0);
                }
                remaining = rods.size();
                result.add(remaining);
            }
        }

        return result;
    }


    public static void main(String[] args) throws Exception{
        List<Integer> rods = new ArrayList<>();
        rods.add(5);
        rods.add(4);
        rods.add(4);
        rods.add(2);
        rods.add(2);
        rods.add(8);

        List<Integer> rods1 = new ArrayList<>();
        rods1.add(1);
        rods1.add(2);
        rods1.add(3);
        rods1.add(4);
        rods1.add(3);
        rods1.add(3);
        rods1.add(2);
        rods1.add(1);

        RodCutt rodCutt = new RodCutt();
        System.out.println(rodCutt.rodOffCut(rods));
        System.out.println(rodCutt.rodOffCut(rods1));
        System.out.println(rodCutt.rodOffCut2(rods));
        System.out.println(rodCutt.rodOffCut2(rods1));
    }

}

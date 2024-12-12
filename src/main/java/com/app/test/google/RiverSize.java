package com.app.test.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * You're given a two-dimensional array (a matrix) of potentially unequal height and width containing only 0s and 1s .
 * Each 0 represents land, and each 1 represents part of river.
 * A river consists of any number of 1s that are either horizontally or vertically adjacent (but not diagonally adjacent).
 * The number of adjacent 1s forming a river determine its size.
 * Not that a river can twist.In other words, it doesn't have to be straight vertical line or a straight horizontal line;
 * it can be L-shaped, for example.
 *
 *
 * Write a function that return an array. of the sizes of all rivers reperesented in the input matrix. The sizes don't need to be any perticular order.
 *
 * sample: input
 *
 * matrix =[
 * [1,0,0,1,0],
 * [1,0,1,0,0],
 * [0,0,1,0,1],
 * [1,0,1,0,1],
 * [1,0,1,1,0],]
 *
 *
 * output
 * [1,2,2,2,5]
 *
 * /*
 * You are given a 2D array of potentially unequal width and height. 0 in the matrix represent land,
 * 1 in the matrix represent water. Write a function which returns the lengths of unique rivers.
 *
 * 0, 0, 0, 1
 * 1, 1, 0, 0,
 * 1, 0, 0, 1,
 * 1, 0, 0, 1
 *
 * returns [1, 4, 2]
 *
 * 0, 0, 0, 1, 1,
 * 1, 1, 0, 0, 1,
 * 0, 0, 0, 1, 1,
 * 0, 0, 0, 1, 0
 *
 * returns [6, 2]
 * */

public class RiverSize {

    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public static int riverSize(int[][] map,int i, int j){
        if(i < 0 || j < 0 || i >= map.length || j >= map[0].length || map[i][j] == 0){
            return 0;
        }
        int count = 1;
        map[i][j] = 0;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            count+= riverSize(map,x, y);
        }
        return count;
    }
    private static ArrayList<Integer> solve(int[][] map){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < map.length;i++){
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 1){
                    ans.add(riverSize(map,i,j));
                }
            }
        }
        return ans;
    }

    //Another Solution

    public static int riverSize1(int[][] map,int i, int j){
        if(i<0 || j<0 || i>=map.length || j>=map[0].length ){
            return 1;
        }

        if(map[i][j]==0) return 0;

        map[i][j]=0;

        return riverSize1(map, i - 1, j) + riverSize1(map, i , j -1) + riverSize1(map, i, j + 1) + riverSize1(map, i + 1, j);
    }


    public static void main(String[] args) {
        int[][] map =
                { {0, 0, 0, 1, 1},
                  {1, 1, 0, 0, 1},
                  {0, 0, 0, 1, 1},
                  {0, 0, 0, 1, 0}
                };


        int[][] matrix ={
        {1,0,0,1,0},
        {1,0,1,0,0},
        {0,0,1,0,1},
        {1,0,1,0,1},
        {1,0,1,1,0}};

        int [][] matrix1={
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 1}
        };


        System.out.println(solve(matrix));
        System.out.println(solve(matrix1));
        System.out.println(solve(map));

        String words = "One Two Three Four";
        int countWords = words.split("\\s").length;
        System.out.println(countWords);

        Map<String, Double> map1 = new HashMap<String, Double>();
        map1.put("1.1", 1.1);
        map1.put("0.1", 0.1);
        map1.put("2.1", 2.1);

        Double min = Collections.min(map1.values());
        System.out.println(min);
    }
}

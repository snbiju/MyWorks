package com.app.codes.google;

import java.util.List;

/**
 * In the solution for the first question there is a bug.
 * The sequenceIdx does not get reset if the next following number is NOT in the sequence.
 * Therefore, it is possible that a sequence is valid even if it is not a continuous part of
 * the array. For example an array = [1,2,3,4,4,5,6] and a sequence = [3,4,6] will validate if the sequenceIdx is not reset,
 * when the next following array number is not a part of the sequence
 */
public class ArraySubSequence {

    public static boolean isValid(List<Integer> array, List<Integer> sequence){

        int listIndex=0;
        for(int val: array) {
            if(val==sequence.get(listIndex)){
                listIndex++;
            }
            if(listIndex==sequence.size()) return true;
        }
        return false;
    }

    public static boolean isValidSequence(int[] array, int[] sequence) {
        int sequenceIdx = 0;

        for (int num : array) {
            if (sequenceIdx < sequence.length && num == sequence[sequenceIdx]) {
                // Current number matches the next expected number in the sequence.
                sequenceIdx++;
            }
        }

        return sequenceIdx == sequence.length;
    }

    public static void main(String[] args) {
        List<Integer> array = List.of(5,1,22,25,6,-1,8,10);
        List<Integer> sequence = List.of(1,6,-1,10);
        List<Integer> sequence1 = List.of(1,5,6,-1,10);
        System.out.println("First:"+isValid(array,sequence));
        System.out.println("Second:"+isValid(array,sequence1));

        int [] firstArr = {5,1,22,25,6,-1,8,10};
        int [] seq ={1,6,-1,10};
        int [] seq1 ={1,5,6,-1,10};
        System.out.println("with array: "+ isValidSequence(firstArr,seq));
        System.out.println("with array2: "+ isValidSequence(firstArr,seq1));
    }
}

package com.app.codes.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ChangeMachine {

    public static List<Integer> getChange(int amount) {
        List<Integer> coins = new ArrayList<>();
        int[] denominations = {200,100,50, 20, 10, 5, 2, 1};

        for (int denomination : denominations) {
            while (amount >= denomination) {
                coins.add(denomination);
                amount -= denomination;
            }
        }

        return coins;
    }

    public static void main(String[] args) {
        int amount = 851;
        List<Integer> change = getChange(amount);

        System.out.println("Change for " + amount + " pence: " + change);
    }
}


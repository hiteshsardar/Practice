package org.com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SumPossibleCoins {

    private static boolean sumPossibleRecursive(int amount, ArrayList<Integer> coins) {
        if (amount == 0)
            return true;

        if (amount < 0)
            return false;

        for (int coin : coins) {
            int subAmount = amount - coin;
            if (sumPossibleRecursive(subAmount, coins))
                return true;
        }
        return false;
    }

    private static boolean sumPossibleMemoization(int amount, ArrayList<Integer> coins, HashMap<Integer, Boolean> memo) {
        if (amount == 0)
            return true;

        if (amount < 0)
            return false;

        if (memo.containsKey(amount))
            return memo.get(amount);

        for (int coin : coins) {
            int subAmount = amount - coin;
            if (sumPossibleMemoization(subAmount, coins,memo)) {
                memo.put(amount, true);
                return true;
            }
        }

        memo.put(amount, false);
        return false;
    }

    public static void main(String[] args) {
        int amount = 20;
        ArrayList<Integer> coins = new ArrayList<>(Arrays.asList(2, 4, 8));
        System.out.println(sumPossibleRecursive(amount, coins));
        System.out.println(sumPossibleMemoization(amount, coins, new HashMap<>()));
    }
}

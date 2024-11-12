package org.com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MinChangeCion {
    private static int minChangeRecursive(int amount, ArrayList<Integer> coins) {
        if (amount == 0)
            return 0;

        if (amount < 0)
            return -1;

        int minCoins = -1;
        for (int coin : coins) {
            int subAmount = amount - coin;
            int subMinCoins = minChangeRecursive(subAmount, coins);

            if (subMinCoins != -1) {
                int totalCoins = subMinCoins + 1;

                if(minCoins == -1 || totalCoins < minCoins)
                    minCoins = totalCoins;
            }

        }

        return minCoins;
    }

    private static int minChangeMemoization(int amount, ArrayList<Integer> coins, HashMap<Integer, Integer> memo) {
        if (amount == 0)
            return 0;

        if (amount < 0)
            return -1;

        if (memo.containsKey(amount))
            return memo.get(amount);

        int minCoins = -1;
        for (int coin : coins) {
            int subAmount = amount - coin;
            int subMinCoins = minChangeMemoization(subAmount, coins, memo);

            if (subMinCoins != -1) {
                int totalCoins = subMinCoins + 1;

                if(minCoins == -1 || totalCoins < minCoins)
                    minCoins = totalCoins;
            }

        }

        memo.put(amount, minCoins);
        return minCoins;
    }

    public static void main(String[] args) {
        int amount = 20;
        ArrayList<Integer> coins = new ArrayList<>(Arrays.asList(2, 4, 8));
        System.out.println(minChangeRecursive(amount, coins));
        System.out.println(minChangeMemoization(amount, coins, new HashMap<>()));
    }
}

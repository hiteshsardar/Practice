package org.com.practice.practice.dp;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingChange {

    private static int countingChangeRecursive(int amount, int coinIndex, List<Integer> coins) {
        if(amount == 0)
            return 1;

        if(coinIndex >= coins.size())
            return 0;

        int val = coins.get(coinIndex);
        int totalWays = 0;
        for(int qty = 0; qty * val <= amount; qty++) {
            int subAmount = amount - (qty * val);
            totalWays += countingChangeRecursive(subAmount, coinIndex + 1, coins);
        }

        return totalWays;
    }

    private static int countingChangeMemoization(int amount, int coinIndex, List<Integer> coins, Map<List<Integer>, Integer> memo) {
        if(amount == 0)
            return 1;

        if(coinIndex >= coins.size())
            return 0;

        List<Integer> key = List.of(amount, coinIndex);
        if(memo.containsKey(key))
            return memo.get(key);

        int val = coins.get(coinIndex);
        int totalWays = 0;
        for(int qty = 0; qty * val <= amount; qty++) {
            int subAmount = amount - (qty * val);
            totalWays += countingChangeMemoization(subAmount, coinIndex + 1, coins, memo);
        }

        memo.put(key, totalWays);
        return totalWays;
    }

    public static void main(String[] args) {
        List<Integer> coins = List.of(1, 2, 3);

        System.out.println(countingChangeRecursive(4, 0, coins));
        System.out.println(countingChangeMemoization(4, 0, coins, new HashMap<>()));
    }
}

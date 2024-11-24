package org.com.practice.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonAdjaCentSum {

    private static int nonAdjaCentSumRecursive(List<Integer> nums, int index) {
        if(index >= nums.size())
            return 0;

        int include = nums.get(index) + nonAdjaCentSumRecursive(nums, index + 2);
        int exclude = nonAdjaCentSumRecursive(nums, index + 1);

        return Math.max(include, exclude);
    }

    private static int nonAdjaCentSumMemoization(List<Integer> nums, int index, Map<Integer, Integer> memo) {
        if(index >= nums.size())
            return 0;

        if(memo.containsKey(index))
            return memo.get(index);

        int include = nums.get(index) + nonAdjaCentSumMemoization(nums, index + 2, memo);
        int exclude = nonAdjaCentSumMemoization(nums, index + 1, memo);

        memo.put(index, Math.max(include, exclude));
        return memo.get(index);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 4, 5, 12, 7);

        System.out.println(nonAdjaCentSumRecursive(nums, 0));
        System.out.println(nonAdjaCentSumMemoization(nums, 0, new HashMap<>()));
    }
}

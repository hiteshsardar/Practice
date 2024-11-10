package org.com.practice.dp;

import java.util.HashMap;

public class TribonacciSeries {
    private static long tribonacciRecursive(int no) {
        if(no == 0 || no == 1)
            return 0;
        if (no == 2)
            return 1;

        return tribonacciRecursive(no - 1) + tribonacciRecursive(no - 2) + tribonacciRecursive(no - 3);
    }

    private static long tribonacciMemoization(int no, HashMap<Integer, Long> memo) {
        if(no == 0 || no == 1)
            return 0;
        if (no == 2)
            return 1;

        if(memo.containsKey(no))
            return memo.get(no);

        long fib = tribonacciMemoization(no - 1, memo) + tribonacciMemoization(no - 2, memo) + tribonacciMemoization(no - 3, memo);
        memo.put(no, fib);
        return fib;
    }

    public static void main(String[] args) {
        int no = 5;
        System.out.println("Fibonacci Series of " + no + " is " + tribonacciRecursive(no));
        System.out.println("Fibonacci Series of " + no + " is " + tribonacciMemoization(no, new HashMap<>()));
    }
}

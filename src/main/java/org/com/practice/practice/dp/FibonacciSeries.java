package org.com.practice.practice.dp;


import java.util.HashMap;

public class FibonacciSeries {
    private static long fibRecursive(int no) {
        if(no == 0 || no == 1)
            return no;

        return fibRecursive(no - 1) + fibRecursive(no - 2);
    }

    private static long fibMemoization(int no, HashMap<Integer, Long> memo) {
        if(no == 0 || no == 1)
            return no;

        if(memo.containsKey(no))
            return memo.get(no);

        long fib = fibMemoization(no - 1, memo) + fibMemoization(no - 2, memo);
        memo.put(no, fib);
        return fib;
    }

    public static void main(String[] args) {
        int no = 20;
        System.out.println("Fibonacci Series of " + no + " is " + fibRecursive(no));
        System.out.println("Fibonacci Series of " + no + " is " + fibMemoization(no, new HashMap<>()));
    }
}

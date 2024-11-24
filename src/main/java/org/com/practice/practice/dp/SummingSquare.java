package org.com.practice.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class SummingSquare {

    private static int summingSquareRecursive(int n) {
        if(n == 0)
            return 0;

        int minSquares = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            int sqr = i * i;
            int subSquares = summingSquareRecursive(n - sqr);
            minSquares = Math.min(minSquares, subSquares + 1);
        }

        return minSquares;
    }

    private static int summingSquareMemoization(int n, Map<Integer, Integer> memo) {
        if(n == 0)
            return 0;

        if(memo.containsKey(n))
            return memo.get(n);

        int minSquares = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            int sqr = i * i;
            int subSquares = summingSquareMemoization(n - sqr, memo);
            minSquares = Math.min(minSquares, subSquares + 1);
        }

        memo.put(n, minSquares);
        return minSquares;
    }

    public static void main(String[] args) {
        int no = 10;

        System.out.println(summingSquareRecursive(no));
        System.out.println(summingSquareMemoization(no, new HashMap<>()));
    }
}

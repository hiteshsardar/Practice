package org.com.practice.practice.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPaths {
    private static int countPathsRecursive(int row, int col, List<List<String>> grid) {
        if(row == grid.size() || col == grid.get(0).size())
            return 0;

        if(grid.get(row).get(col).equals("X"))
            return 0;

        if(row == grid.size() - 1 && col == grid.get(0).size() - 1)
            return 1;


        return countPathsRecursive(row + 1, col, grid) + countPathsRecursive(row, col + 1, grid);
    }

    private static int countPathsMemoization(int row, int col, List<List<String>> grid, Map<List<Integer>, Integer> memo) {
        if(row == grid.size() || col == grid.get(0).size())
            return 0;

        if(grid.get(row).get(col).equals("X"))
            return 0;

        if(row == grid.size() - 1 && col == grid.get(0).size() - 1)
            return 1;

        List<Integer> key = List.of(row, col);
        if(memo.containsKey(key))
            return memo.get(key);

        int result =  countPathsMemoization(row + 1, col, grid, memo) + countPathsMemoization(row, col + 1, grid, memo);
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> grid = new ArrayList<>();
        List<String> col1 = new ArrayList<>();
        col1.add("A");
        col1.add("A");
        col1.add("X");
        grid.add(col1);

        List<String> col2 = new ArrayList<>();
        col2.add("A");
        col2.add("A");
        col2.add("A");
        grid.add(col2);

        List<String> col3 = new ArrayList<>();
        col3.add("A");
        col3.add("A");
        col3.add("A");
        grid.add(col3);


        System.out.println("No of paths " + countPathsRecursive(0, 0, grid));
        System.out.println("No of paths " + countPathsMemoization(0, 0, grid, new HashMap<>()));
    }
}

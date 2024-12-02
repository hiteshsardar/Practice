import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPathSum {

    private static int maxPathSumRecursive(int row, int col, List<List<Integer>> grid) {
        if(row == grid.size() || col == grid.get(0).size())
            return 0;

        if(row == grid.size() - 1 && col == grid.get(0).size() - 1)
            return grid.get(row).get(col);

        return grid.get(row).get(col) + Math.max(maxPathSumRecursive(row + 1, col, grid), maxPathSumRecursive(row, col + 1, grid));
    }

    private static int maxPathSumMemoization(int row, int col, List<List<Integer>> grid, Map<List<Integer>, Integer> memo) {
        if(row == grid.size() || col == grid.get(0).size())
            return 0;

        if(row == grid.size() - 1 && col == grid.get(0).size() - 1)
            return grid.get(row).get(col);

        List<Integer> key = List.of(row, col);
        if(memo.containsKey(key))
            return memo.get(key);

        int result = grid.get(row).get(col) + Math.max(maxPathSumMemoization(row + 1, col, grid, memo), maxPathSumMemoization(row, col + 1, grid, memo));
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> col1 = new ArrayList<>();
        col1.add(1);
        col1.add(3);
        col1.add(12);
        grid.add(col1);

        List<Integer> col2 = new ArrayList<>();
        col2.add(5);
        col2.add(6);
        col2.add(2);
        grid.add(col2);

        System.out.println("No of paths " + maxPathSumRecursive(0, 0, grid));
        System.out.println("No of paths " + maxPathSumMemoization(0, 0, grid, new HashMap<>()));
    }
}

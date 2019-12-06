package medium;

/**
 * Problem 62: Unique Paths
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        return helper(m - 1, n - 1, grid);
    }

    private int helper(int m, int n, int[][] grid) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (grid[m][n] == 0) {
            grid[m][n] = helper(m - 1, n, grid) + helper(m, n - 1, grid);
        }
        return grid[m][n];
    }

    public static void main(String[] args) {
        int result = new UniquePaths().uniquePaths(3, 2);
        System.out.println(result);
    }
}

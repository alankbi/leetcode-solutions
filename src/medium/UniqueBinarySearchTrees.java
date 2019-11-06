package medium;

/**
 * Problem 96: Unique Binary Search Trees
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return numTrees(1, n, dp);
    }

    private int numTrees(int min, int max, int[][] dp) {
        if (min >= max) {
            return 1;
        }
        if (dp[min][max] != 0) {
            return dp[min][max];
        }

        int count = 0;
        for (int i = min; i <= max; i++) {
            count += numTrees(min, i - 1, dp) * numTrees(i + 1, max, dp);
        }
        dp[min][max] = count;
        return count;
    }

    public static void main(String[] args) {
        int result = new UniqueBinarySearchTrees().numTrees(20);
        System.out.println(result);
    }
}

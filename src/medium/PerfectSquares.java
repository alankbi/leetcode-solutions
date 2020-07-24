package medium;

/**
 * Problem 279: Perfect Squares
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            int k = 1;

            while (k * k <= i) {
                dp[i] = Math.min(dp[i], 1 + dp[i - k * k]);
                k++;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int result = new PerfectSquares().numSquares(12);
        System.out.println(result);
    }
}

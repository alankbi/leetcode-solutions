package medium;

/**
 * Problem 518: Coin Change 2
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= coins.length; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i - coins[j - 1] >= 0) {
                    dp[i][j] += dp[i - coins[j - 1]][j];
                }
            }
        }
        return dp[amount][coins.length];
    }

    public static void main(String[] args) {
        int result = new CoinChange2().change(5, new int[] {1, 2, 5});
        System.out.println(result);
    }
}

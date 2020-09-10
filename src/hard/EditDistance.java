package hard;

/**
 * Problem 72: Edit Distance
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Populate 0th row and column with values 0 to m and n
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Replace character
                dp[i][j] = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j]++;
                }

                // Add character
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);

                // Remove character
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);

            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int result = new EditDistance().minDistance("horse", "ros");
        System.out.println(result);
    }
}

package medium;

/**
 * Problem 376: Wiggle Subsequence
 */
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                } else if (nums[i] < nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }

                max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int result = new WiggleSubsequence().wiggleMaxLength(new int[] {1, 7, 4, 9, 2, 5});
        System.out.println(result);
    }
}

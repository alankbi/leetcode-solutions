package medium;

/**
 * Problem 416: Partition Equal Subset Sum
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        boolean[][] dp = new boolean[sum / 2 + 1][nums.length + 1];
        dp[0][0] = true;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (i - nums[j - 1] >= 0) {
                    dp[i][j] |= dp[i - nums[j - 1]][j - 1];
                }
                dp[i][j] |= dp[i][j - 1];
            }
        }

        return dp[sum / 2][nums.length];
    }

    public static void main(String[] args) {
        boolean result = new PartitionEqualSubsetSum().canPartition(new int[] {1, 5, 11, 5});
        System.out.println(result);
    }
}

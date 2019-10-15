package medium;

import java.util.Arrays;

/**
 * Problem 322: Coin Change
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] min = new int[amount + 1];
        for (int i = 1; i < min.length; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        Arrays.sort(coins);

        for (int i = 1; i <= amount; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                if (i - coins[j] >= 0 && min[i - coins[j]] != Integer.MAX_VALUE) {
                    min[i] = Math.min(min[i], 1 + min[i - coins[j]]);
                }
            }
        }
        if (min[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return min[amount];
    }

    public static void main(String[] args) {
        int result = new CoinChange().coinChange(new int[] {1, 2, 5}, 11);
        System.out.println(result);
    }
}

package easy;

/**
 * Problem 121: Best Time to Buy and Sell Stock
 */
public class BestTimeBuySellStock {

    public int maxProfit(int[] prices) {
        int max = 0;
        int maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            }
            maxProfit = Math.max(maxProfit, max - prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int result = new BestTimeBuySellStock().maxProfit(new int[] {7, 1, 5, 3, 6, 4});
        System.out.println(result);
    }
}

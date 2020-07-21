package medium;

/**
 * Problem 91: Decode Ways
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i + 1] = dp[i];
            }

            if (i > 0) {
                int num = Integer.parseInt(s.substring(i - 1, i + 1));
                if (num >= 10 && num <= 26) {
                    dp[i + 1] += dp[i - 1];
                }
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int result = new DecodeWays().numDecodings("12");
        System.out.println(result);
    }
}

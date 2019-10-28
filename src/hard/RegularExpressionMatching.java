package hard;

/**
 * Problem 10: Regular Expression Matching
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        // dp[i][j] is the value of isMatch(s.substring(i), p.substring(j)
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0, dp);
    }

    private boolean isMatch(String s, String p, int sIndex, int pIndex, Boolean[][] dp) {
        if (dp[sIndex][pIndex] != null) {
            return dp[sIndex][pIndex];
        }

        if (pIndex >= p.length()) {
            dp[sIndex][pIndex] = (sIndex >= s.length());
        } else {
            boolean firstCharMatches = sIndex < s.length() &&
                    (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.');
            if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
                if (dp[sIndex][pIndex + 2] == null) {
                    dp[sIndex][pIndex + 2] = isMatch(s, p, sIndex, pIndex + 2, dp);
                }

                dp[sIndex][pIndex] = dp[sIndex][pIndex + 2];
                if (firstCharMatches && dp[sIndex + 1][pIndex] == null) {
                    dp[sIndex + 1][pIndex] = isMatch(s, p, sIndex + 1, pIndex, dp);
                    dp[sIndex][pIndex] |= dp[sIndex + 1][pIndex];
                }

            } else {
                if (!firstCharMatches) {
                    dp[sIndex][pIndex] = false;
                } else if (dp[sIndex + 1][pIndex + 1] == null) {
                    dp[sIndex + 1][pIndex + 1] = isMatch(s, p, sIndex + 1, pIndex + 1, dp);
                    dp[sIndex][pIndex] = dp[sIndex + 1][pIndex + 1];
                } else {
                    dp[sIndex][pIndex] = dp[sIndex + 1][pIndex + 1];
                }
            }
        }
        return dp[sIndex][pIndex];
    }

    // Recursive without dynamic programming; exponential runtime
    private boolean isMatchRecurive(String s, String p, int sIndex, int pIndex) {
        if (pIndex >= p.length()) {
            return sIndex >= s.length();
        }

        boolean firstCharMatches = sIndex < s.length() &&
                (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.');
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            return isMatchRecurive(s, p, sIndex, pIndex + 2) || firstCharMatches &&
                    isMatchRecurive(s, p, sIndex + 1, pIndex);
        }
        return firstCharMatches && isMatchRecurive(s, p, sIndex + 1, pIndex + 1);
    }

    public static void main(String[] args) {
        boolean result = new RegularExpressionMatching().isMatch("aa", "a");
        System.out.println(result);
    }
}

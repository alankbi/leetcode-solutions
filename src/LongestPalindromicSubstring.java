/**
 * Problem 5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String max = "";

        // Test odd length substrings
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            while (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
                j++;
            }
            j--; // Bring j back to highest valid value

            String ans = s.substring(i - j, i + j + 1);
            if (ans.length() > max.length()) {
                max = ans;
            }
        }

        // Test even length substrings
        for (int i = 0; i < s.length() - 1; i++) {
            int j = 0;
            while (i - j >= 0 && i + j + 1 < s.length() && s.charAt(i - j) == s.charAt(i + j + 1)) {
                j++;
            }
            j--;
            String ans = s.substring(i - j, i + j + 2);
            if (ans.length() > max.length()) {
                max = ans;
            }
        }
        return max;
    }

    // My failed attempt at a "dynamic programming" approach -
    // it ended up performing 10x slower than the one above :/
    public String longestPalindromeAltSolution(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String[][] arr = new String[s.length()][s.length()];
        return palindromeLength(arr, 0, s.length() - 1, s);
    }

    private String palindromeLength(String[][] arr, int left, int right, String s) {
        if (arr[left][right] != null) {
            return arr[left][right];
        }

        String value;
        if (right - left < 0) {
            value = "";
        } else if (right == left) {
            value = s.substring(left, left + 1);
        } else if (s.charAt(left) == s.charAt(right) &&
                palindromeLength(arr, left + 1, right - 1, s).length() == right - left - 1) {
            value = s.substring(left, right + 1);
        } else {
            String leftSubstring = palindromeLength(arr, left, right - 1, s);

            String rightSubstring = palindromeLength(arr, left + 1, right, s);
            value = leftSubstring.length() < rightSubstring.length() ? rightSubstring : leftSubstring;
        }
        arr[left][right] = value;
        return value;
    }

    public static void main(String[] args) {
        String result = new LongestPalindromicSubstring().longestPalindrome("babad");
        System.out.println(result);
    }
}

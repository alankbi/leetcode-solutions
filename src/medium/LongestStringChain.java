package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 1048: Longest String Chain
 */
public class LongestStringChain {

    public int longestStrChain(String[] words) {
        sortByLength(words);
        System.out.println(Arrays.toString(words));

        int[] dp = new int[words.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
            dp[i] = 1;
        }

        // Start main dynamic programming loop
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                String newWord = word.substring(0, j) + word.substring(j + 1);

                if (map.containsKey(newWord)) {
                    int value = dp[map.get(newWord)];
                    dp[i] = Math.max(dp[i], value + 1);
                }
            }
        }

        int max = 0;
        for (int val : dp) {
            max = Math.max(max, val);
        }

        return max;
    }

    private void sortByLength(String[] words) {
        // Comparator equivalent to (a, b) -> a.length() - b.length()
        Arrays.sort(words, Comparator.comparingInt(String::length));
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};

        int result = new LongestStringChain().longestStrChain(words);
        System.out.println(result);
    }
}

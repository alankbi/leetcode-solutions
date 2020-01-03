package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 3: Longest Substring Without Repeating Characters
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";

        int length = new LongestSubstring().lengthOfLongestSubstring(str);
        System.out.println(length);
    }
}

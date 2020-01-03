package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 76: Minimum Window Substring
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || t.isEmpty()) {
            return "";
        }

        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
                count++;
            }
            map.put(c, map.get(c) + 1);
        }

        while (count > 0 && right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count--;
                }
            }
            right++;
        }

        if (count > 0) {
            return "";
        }

        right--;
        minRight = right;

        while (right < s.length()) {
            while (left < right) {
                char c = s.charAt(left);
                left++;
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) {
                        break;
                    }
                }
                if (right - left < minRight - minLeft) {
                    minLeft = left;
                    minRight = right;
                }
            }

            right++;
            while (right < s.length()) {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        break;
                    }
                }
                right++;
            }

            if (right < s.length() && right - left < minRight - minLeft) {
                minLeft = left;
                minRight = right;
            }
        }

        return s.substring(minLeft, minRight + 1);
    }

    public static void main(String[] args) {
        String result = new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }
}

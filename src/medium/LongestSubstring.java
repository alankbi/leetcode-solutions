package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 3. Longest Substring Without Repeating Characters
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Set<Character> uniqueChars = new HashSet<>();

        for (int i = 0; i < s.length() - longest; i++) {
            int count = 0;
            int index = i;
            while (index < s.length() && !uniqueChars.contains(s.charAt(index))) {
                uniqueChars.add(s.charAt(index));
                count++;
                index++;
            }
            if (count > longest) {
                longest = count;
            }
            uniqueChars.clear();
        }
        return longest;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";

        int length = new LongestSubstring().lengthOfLongestSubstring(str);
        System.out.println(length);
    }
}

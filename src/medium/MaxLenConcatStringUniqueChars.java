package medium;

import java.util.Arrays;
import java.util.List;

/**
 * Problem 1239: Maximum Length of a Concatenated String with Unique Characters
 */
public class MaxLenConcatStringUniqueChars {

    private int max;

    public int maxLength(List<String> arr) {
        max = 0;
        maxLength(arr, 0, new StringBuilder());
        return max;
    }

    private void maxLength(List<String> arr, int index, StringBuilder current) {
        if (index >= arr.size()) {
            checkValidString(current);
        } else {
            maxLength(arr, index + 1, current);
            current.append(arr.get(index));
            maxLength(arr, index + 1, current);
            current.setLength(current.length() - arr.get(index).length());
        }
    }

    private void checkValidString(StringBuilder s) {
        boolean[] charFound = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (charFound[index]) {
                return;
            }
            charFound[index] = true;
        }

        max = Math.max(max, s.length());
    }

    public static void main(String[] args) {
        List<String> arr = Arrays.asList("un", "iq", "ue");

        int result = new MaxLenConcatStringUniqueChars().maxLength(arr);
        System.out.println(result);
    }
}

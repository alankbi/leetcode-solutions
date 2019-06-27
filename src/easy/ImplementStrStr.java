package easy;

/**
 * Problem 28: Implement strStr()
 */
public class ImplementStrStr {

    // Convoluted and inefficient algorithm - a faster solution would have just been
    // to loop through each index of haystack and compare the substring to needle
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int i = 0, j = 0;
        int index = -1;
        char firstChar = needle.charAt(0);

        while (i < haystack.length() && j < needle.length()) {
            // Index to go back to if a character in the middle of the haystack
            // matches with the needle's first character
            if (haystack.charAt(i) == firstChar && j != 0 && index == -1) {
                index = i;
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                j = 0;
            }
            if (index != -1 && j == 0) {
                i = index;
                index = -1;
            } else {
                i++;
            }
        }

        // If true, it means that a match was found
        if (j == needle.length()) {
            return i - needle.length();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int result = new ImplementStrStr().strStr("hello", "ll");
        System.out.println(result);
    }
}

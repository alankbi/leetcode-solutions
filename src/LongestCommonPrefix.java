/**
 * Problem 14: Longest Common Prefix
 */
class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (true) {
            char c;
            if (strs.length > 0 && strs[0].length() > i) {
                c = strs[0].charAt(i);
            } else {
                return result.toString();
            }

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    return result.toString();
                }
            }
            result.append(c);
            i++;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        String result = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(result);
    }
}

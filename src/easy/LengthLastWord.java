package easy;

/**
 * Problem 58: Length of Last Word
 */
public class LengthLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        if (end < 0) {
            return 0;
        }

        int index = end - 1;
        while (index >= 0 && s.charAt(index) != ' ') {
            index--;
        }

        return end - index;
    }

    public static void main(String[] args) {
        int result = new LengthLastWord().lengthOfLastWord("Hello World");
        System.out.println(result);
    }
}

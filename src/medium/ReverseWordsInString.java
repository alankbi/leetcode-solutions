package medium;

/**
 * Problem 151: Reverse Words in a String
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder reversedString = new StringBuilder();
        int startIndex = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            // Found a new word
            if (c != ' ' && startIndex == -1) {
                startIndex = i;
            } else if (c == ' ' && startIndex != -1) {
                // Finished finding a word
                reversedString.append(s.substring(i + 1, startIndex + 1));
                reversedString.append(' ');
                startIndex = -1;
            }
        }

        // Add last word if it exists
        if (startIndex != -1) {
            reversedString.append(s.substring(0, startIndex + 1));
            reversedString.append(' ');
        }

        // Trim off last space character
        if (reversedString.length() > 0) {
            return reversedString.substring(0, reversedString.length() - 1);
        }
        // If no words were found
        return "";
    }

    public static void main(String[] args) {
        String result = new ReverseWordsInString().reverseWords("the sky is blue");
        System.out.println(result);
    }
}

package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 22: Generate Parentheses
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> results = new ArrayList<>();
        generateParenthesis(results, n * 2, 0, "");
        return results;
    }

    private void generateParenthesis(List<String> results, int n, int openCount, String str) {
        if (n <= 0 && openCount == 0) {
            results.add(str);
        } else if (n > 0) {
            generateParenthesis(results, n - 1, openCount + 1, str + "(");
            if (openCount > 0) {
                generateParenthesis(results, n - 1, openCount - 1, str + ")");
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = new GenerateParentheses().generateParenthesis(3);
        System.out.println(result);
    }
}

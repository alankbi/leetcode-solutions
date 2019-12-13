package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem 71: Simplify Path
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        StringBuilder results = new StringBuilder();
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String s : paths) {
            if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!s.equals("..") && !s.equals(".") && !s.isEmpty()) {
                stack.push(s);
            }
        }

        Deque<String> reverse = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            reverse.push(stack.pop());
        }

        while (!reverse.isEmpty()) {
            results.append("/").append(reverse.pop());
        }

        if (results.length() == 0) {
            results.append("/");
        }
        return results.toString();
    }

    public static void main(String[] args) {
        String result = new SimplifyPath().simplifyPath("/a//b////c/d//././/..");
        System.out.println(result);
    }
}

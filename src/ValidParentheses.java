import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 20. Valid Parentheses
 */
class ValidParentheses {

    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (brackets.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || c != brackets.get(stack.peek())){
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean result = new ValidParentheses().isValid("()");
        System.out.println(result);
    }
}

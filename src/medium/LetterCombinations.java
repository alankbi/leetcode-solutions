package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 17: Letter Combinations of a Phone Number
 */
public class LetterCombinations {
    private static Map<Character, char[]> digitMap = createDigitMap();

    private static Map<Character, char[]> createDigitMap() {
        Map<Character, char[]> digitMap = new HashMap<>();
        digitMap.put('2', new char[] {'a', 'b', 'c'});
        digitMap.put('3', new char[] {'d', 'e', 'f'});
        digitMap.put('4', new char[] {'g', 'h', 'i'});
        digitMap.put('5', new char[] {'j', 'k', 'l'});
        digitMap.put('6', new char[] {'m', 'n', 'o'});
        digitMap.put('7', new char[] {'p', 'q', 'r', 's'});
        digitMap.put('8', new char[] {'t', 'u', 'v'});
        digitMap.put('9', new char[] {'w', 'x', 'y', 'z'});
        return digitMap;
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> combinations =  new ArrayList<>();
        generateLetterCombinations(digits, "", 0, combinations);
        return combinations;
    }

    private void generateLetterCombinations(String digits, String current,
                                            int index, List<String> combinations) {
        if (index >= digits.length()) {
            combinations.add(current);
        } else {
            for (char c : digitMap.get(digits.charAt(index))) {
                generateLetterCombinations(digits, current + c, index + 1, combinations);
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = new LetterCombinations().letterCombinations("23");
        System.out.println(result);
    }
}

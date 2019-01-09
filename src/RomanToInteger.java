import java.util.HashMap;
import java.util.Map;

/**
 * Problem 13: Roman To Integer
 */
class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> symbols = new HashMap<>();
        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);
        symbols.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int value = symbols.get(s.charAt(i));
            if (value < symbols.get(s.charAt(i + 1))) {
                sum -= value;
            } else {
                sum += value;
            }
        }
        if (s.length() > 0) {
            sum += symbols.get(s.charAt(s.length() - 1));
        }

        return sum;
    }

    public static void main(String[] args) {
        int num = new RomanToInteger().romanToInt("III");
        System.out.println(num);
    }
}

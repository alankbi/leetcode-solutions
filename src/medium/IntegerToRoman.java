package medium;

/**
 * Problem 12: Integer to Roman
 */
public class IntegerToRoman {
    private final static String[] numerals = new String[] {"I", "IV", "V", "IX", "X", "XL", "L",
            "XC", "C", "CD", "D", "CM", "M"};
    private final static int[] values = new int[] {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    public String intToRoman(int num) {
        String result = "";
        for (int i = numerals.length - 1; i >= 0; i--) {
            while (num >= values[i]) {
                result += numerals[i];
                num -= values[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String result = new IntegerToRoman().intToRoman(3);
        System.out.println(result);
    }
}

package medium;

/**
 * Problem 6. ZigZag Conversion
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            int index = row;

            while (index < s.length()) {
                result.append(s.charAt(index));

                // Character along the diagonal
                int middleIndex = index + (numRows - row - 1) * 2;
                if (row != 0 && row != numRows - 1 && middleIndex >= 0 && middleIndex < s.length()) {
                    result.append(s.charAt(middleIndex));
                }
                // The next vertical column in the row
                index += numRows * 2 - 2;
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = new ZigZagConversion().convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }
}

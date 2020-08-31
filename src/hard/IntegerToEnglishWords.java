package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 273: Integer to English Words
 */
public class IntegerToEnglishWords {

    private static final Map<Integer, String> digits = new HashMap<>();
    private static final Map<Integer, String> tensMapping = new HashMap<>();
    private static final Map<Integer, String> magnitudeMapping = new HashMap<>();

    private static final int TEN = 10;
    private static final int HUNDRED = 100;
    private static final int THOUSAND = 1000;

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        initializeMappings();

        List<List<String>> groupWordsAsList = new ArrayList<>();
        int magnitude = 0; // represents 0-999, 1000-9999, etc.
        while (num > 0) {
            int group = num % THOUSAND;
            num /= THOUSAND;

            if (group == 0) {
                magnitude++;
                continue;
            }

            List<String> groupWords = new ArrayList<>();

            int hundredsDigit = group / HUNDRED;
            if (hundredsDigit > 0) {
                groupWords.add(digits.get(hundredsDigit) + " Hundred");
            }

            int tens = group % HUNDRED;

            // 1 - 19
            if (digits.containsKey(tens)) {
                groupWords.add(digits.get(tens));
            } else {
                int tensDigit = tens / TEN;
                if (tensDigit > 0) {
                    groupWords.add(tensMapping.get(tensDigit));
                }

                int digit = group % TEN;
                if (digit > 0) {
                    groupWords.add(digits.get(digit));
                }
            }

            if (magnitude > 0) {
                groupWords.add(magnitudeMapping.get(magnitude));
            }
            magnitude++;
            groupWordsAsList.add(groupWords);
        }

        StringBuilder words = new StringBuilder();
        for (int i = groupWordsAsList.size() - 1; i >= 0; i--) {
            for (String word : groupWordsAsList.get(i)) {
                words.append(word).append(" ");
            }
        }

        words.setLength(words.length() - 1);
        return words.toString();
    }

    private static void initializeMappings() {
        digits.put(1, "One");
        digits.put(2, "Two");
        digits.put(3, "Three");
        digits.put(4, "Four");
        digits.put(5, "Five");
        digits.put(6, "Six");
        digits.put(7, "Seven");
        digits.put(8, "Eight");
        digits.put(9, "Nine");
        digits.put(10, "Ten");
        digits.put(11, "Eleven");
        digits.put(12, "Twelve");
        digits.put(13, "Thirteen");
        digits.put(14, "Fourteen");
        digits.put(15, "Fifteen");
        digits.put(16, "Sixteen");
        digits.put(17, "Seventeen");
        digits.put(18, "Eighteen");
        digits.put(19, "Nineteen");

        tensMapping.put(2, "Twenty");
        tensMapping.put(3, "Thirty");
        tensMapping.put(4, "Forty");
        tensMapping.put(5, "Fifty");
        tensMapping.put(6, "Sixty");
        tensMapping.put(7, "Seventy");
        tensMapping.put(8, "Eighty");
        tensMapping.put(9, "Ninety");

        magnitudeMapping.put(1, "Thousand");
        magnitudeMapping.put(2, "Million");
        magnitudeMapping.put(3, "Billion");
    }

    public static void main(String[] args) {
        String result = new IntegerToEnglishWords().numberToWords(123);
        System.out.println(result);
    }
}

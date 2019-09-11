package medium;

/**
 * Problem 43: Multiply Strings
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        // Multiplies numbers in parts and stores in an array
        // e.g. the number 144 could be represented as [0, 1, 4, 4] or [1, 4, 4]
        int[] products = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                // Multiply the two digits together and store in the corresponding indices in the array
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                products[i + j] += num / 10;
                products[i + j + 1] += num % 10;
            }
        }

        // Carry over values greater than 10
        for (int i = products.length - 1; i > 0; i--) {
            if (products[i] >= 10) {
                products[i - 1] += products[i] / 10;
                products[i] %= 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < products.length; i++) {
            result.append(products[i]);
        }

        // Get rid of leading zeros
        int k = 0;
        while (k < result.length() - 1 && result.charAt(k) == '0') {
            k++;
        }
        return result.toString().substring(k);
    }

    public static void main(String[] args) {
        String result = new MultiplyStrings().multiply("2", "3");
        System.out.println(result);
    }
}

package easy;

import java.util.Arrays;

/**
 * Problem 66: Plus One
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }

        if (carry > 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] result = new PlusOne().plusOne(new int[] {1, 2, 3});
        System.out.println(Arrays.toString(result));
    }
}

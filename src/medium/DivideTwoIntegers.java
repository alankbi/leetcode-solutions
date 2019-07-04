package medium;

/**
 * Problem 29: Divide Two Integers
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
        long result = sign * divide(Math.abs((long) dividend), Math.abs((long) divisor));
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }

    private long divide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long multiplier = 1;
        long k = divisor;
        while (k + k <= dividend) {
            k += k;
            multiplier += multiplier;
        }
        return multiplier + divide(dividend - k, divisor);
    }

    public static void main(String[] args) {
        int result = new DivideTwoIntegers().divide(10, 3);
        System.out.println(result);
    }
}

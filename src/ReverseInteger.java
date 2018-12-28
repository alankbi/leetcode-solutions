/**
 * Problem 7: Reverse Integer
 */
class ReverseInteger {

    public int reverse(int x) {
        long temp = Math.abs((long) x);
        long result = 0;

        while (temp != 0) {
            result *= 10;
            result += temp % 10;
            temp /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            result *= -1;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int result = new ReverseInteger().reverse(123);
        System.out.println(result);
    }
}

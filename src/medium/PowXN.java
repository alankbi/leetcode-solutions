package medium;

/**
 * Problem 50: Pow(x, n)
 */
public class PowXN {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double extraFactor = (n % 2 == 0) ? 1.0 : x;
        if (n < 0) {
            return 1.0 / extraFactor * myPow((1.0 / x) * (1.0 / x), -(n / 2));
        }
        return extraFactor * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        double result = new PowXN().myPow(2.0, 10);
        System.out.println(result);
    }
}

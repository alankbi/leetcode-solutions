package easy;

/**
 * Problem 69: Sqrt(x)
 */
public class SquareRootX {

    // Essentially a binary search that finds the
    // last index that still works
    public int mySqrt(int x) {
        long low = 0;
        long high = (long) x + 1;
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (mid * mid > x) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return (int) low;
    }

    public static void main(String[]args){
        int result = new SquareRootX().mySqrt(4);
        System.out.println(result);
    }
}

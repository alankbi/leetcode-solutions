package easy;

/**
 * Problem 70: Climbing Stairs
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] lastTwo = {0, 1};
        int lastIndex = 0;
        for (int i = 1; i <= n; i++) {
            lastTwo[lastIndex] = lastTwo[0] + lastTwo[1];
            lastIndex = 1 - lastIndex;
        }

        return lastTwo[1 - lastIndex];
    }

    public static void main(String[] args) {
        int result = new ClimbingStairs().climbStairs(2);
        System.out.println(result);
    }
}

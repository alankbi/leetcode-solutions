package medium;

/**
 * Problem 55: Jump Game
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxIndex < i) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new JumpGame().canJump(new int[] {2, 3, 1, 1, 4});
        System.out.println(result);
    }
}

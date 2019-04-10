package medium;

import java.util.Arrays;

/**
 * Problem 16: 3Sum Closest
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minDist = Integer.MAX_VALUE;
        int total = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int first = i;
            int second = i + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (Math.abs(sum - target) < minDist) {
                    minDist = Math.abs(sum - target);
                    total = sum;
                }

                if (sum < target) {
                    second++;
                } else if (sum > target) {
                    third--;
                } else {
                    return total;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int result = new ThreeSumClosest().threeSumClosest(new int[] {-1, 2, 1, -4}, 1);
        System.out.println(result);
    }
}

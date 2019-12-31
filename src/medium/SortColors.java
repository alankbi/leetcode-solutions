package medium;

import java.util.Arrays;

/**
 * Problem 75: Sort Colors
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;

        int k = 0;
        while (k <= twoIndex) {
            if (nums[k] == 0) {
                swap(nums, k++, zeroIndex++);
            } else if (nums[k] == 2) {
                swap(nums, k, twoIndex--);
            } else {
                k++;
            }
        }
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

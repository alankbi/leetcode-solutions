package easy;

import java.util.Arrays;

/**
 * Problem 26: Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {
        int duplicateCount = 0;

        for (int i = 1; i < nums.length; i++) {
            nums[i - duplicateCount] = nums[i];
            if (nums[i - duplicateCount - 1] == nums[i]) {
                duplicateCount++;
            }
        }
        return nums.length - duplicateCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int result = new RemoveDuplicatesSortedArray().removeDuplicates(nums);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }
}

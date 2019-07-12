package medium;

import java.util.Arrays;

/**
 * Problem 31: Next Permutation
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int k = nums.length - 1;
        int index = -1;
        // Find highest index where the value is lower than the next
        while (k > 0) {
            if (nums[k] > nums[k - 1]) {
                index = k - 1;
                break;
            }
            k--;
        }
        if (index == -1) {
            for (int i = 0; i < nums.length / 2; i++) {
                swap(i, nums.length - i - 1, nums);
            }
            return;
        }

        // Swap with smallest value greater than nums[index]
        while (k < nums.length && nums[k] > nums[index]) {
            k++;
        }
        swap(index, k - 1, nums);

        // Swap remaining values to the right of index
        for (int i = index + 1; i < (nums.length + index + 1) / 2; i++) {
            swap(i, nums.length - i + index, nums);
        }
    }

    private void swap(int i1, int i2, int[] nums) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {2,5,4,3};
//        int[] nums = {3,1,4,4,2,3,4,0};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

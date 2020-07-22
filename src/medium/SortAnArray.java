package medium;

import java.util.Arrays;

/**
 * Problem 912: Sort an Array
 */
public class SortAnArray {

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = (int) (Math.random() * (right - left + 1)) + left;
        swap(nums, pivot, right);

        int index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[right]) {
                swap(nums, i, index);
                index++;
            }
        }

        swap(nums, right, index);
        sort(nums, left, index - 1);
        sort(nums, index + 1, right);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] result = new SortAnArray().sortArray(new int[] {5, 2, 3, 1});
        System.out.println(Arrays.toString(result));
    }
}

package medium;

import java.util.Arrays;

/**
 * Problem 34: Find First and Last Position of Element in Sorted Array
 */
public class FirstAndLastInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int midIndex = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                midIndex = middle;
                break;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        if (midIndex == -1) {
            return new int[] {-1, -1};
        }

        int leftIndex = midIndex;
        while (leftIndex >= 0 && nums[leftIndex] == target) {
            leftIndex--;
        }

        int rightIndex = midIndex;
        while (rightIndex < nums.length && nums[rightIndex] == target) {
            rightIndex++;
        }

        return new int[] {leftIndex + 1, rightIndex - 1};
    }

    public static void main(String[] args) {
        int[] result = new FirstAndLastInSortedArray().searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(result));
    }
}

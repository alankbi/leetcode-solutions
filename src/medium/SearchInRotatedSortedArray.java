package medium;

/**
 * Problem 33: Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        // If array isn't rotated (highest element at the end)
        if (nums[nums.length - 1] > nums[0]) {
            return search(nums, target, 0);
        }

        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) / 2;
        // middle gives index of highest element
        while (left < right && nums[middle] < nums[middle + 1]) {
            if (nums[middle] > nums[left]) {
                left = middle;
            } else {
                right = middle;
            }
            middle = (left + right) / 2;
        }

        int pivot = nums.length - 1 - middle;
        return search(nums, target, pivot);
    }

    private int search(int[] nums, int target, int pivot) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int adjustedMiddle = (middle - pivot + nums.length) % nums.length;

            if (nums[adjustedMiddle] == target) {
                return adjustedMiddle;
            }
            if (nums[adjustedMiddle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int result = new SearchInRotatedSortedArray().search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(result);
    }
}

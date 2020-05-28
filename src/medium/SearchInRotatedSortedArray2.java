package medium;

/**
 * Problem 81: Search in Rotated Sorted Array II
 */
public class SearchInRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return search(nums, target, 0);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else if (nums[mid] == nums[left] && mid > left) {
                left++;
            } else {
                right = mid;
            }
        }

        return search(nums, target, left + 1);
    }

    private boolean search(int[] nums, int target, int pivot) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            int val = nums[(mid + pivot) % nums.length];

            if (val < target) {
                left = mid + 1;
            } else if (val > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        System.out.println(left + 1);

        return nums[(left + pivot) % nums.length] == target;
    }

    public static void main(String[] args) {
        boolean result = new SearchInRotatedSortedArray2().search(new int[] {2, 5, 6, 0, 0, 1, 2}, 0);
        System.out.println(result);
    }
}

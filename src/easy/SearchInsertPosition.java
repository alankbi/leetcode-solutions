package easy;

/**
 * Problem 35: Search Insert Position
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (target > nums[mid] ? mid + 1 : mid);
    }

    public static void main(String[] args) {
        int result = new SearchInsertPosition().searchInsert(new int[] {1, 3, 5, 6}, 5);
        System.out.println(result);
    }
}

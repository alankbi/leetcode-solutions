package easy;

/**
 * Problem 169: Majority Element
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private int majorityElement(int[] nums, int first, int last) {
        if (first >= last) {
            return nums[last];
        }

        int mid = (first + last) / 2;
        int left = majorityElement(nums, first, mid);
        int right = majorityElement(nums, mid + 1, last);

        if (left == right) {
            return left;
        }

        int count = 0;
        for (int i = first; i <= last; i++) {
            if (nums[i] == left) {
                count++;
            }
        }
        if (count > (last - first + 1) / 2) {
            return left;
        }

        count = 0;
        for (int i = first; i <= last; i++) {
            if (nums[i] == right) {
                count++;
            }
        }
        if (count > (last - first + 1) / 2) {
            return right;
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int result = new MajorityElement().majorityElement(new int[] {3, 2, 3});
        System.out.println(result);
    }
}

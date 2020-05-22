package medium;

/**
 * Problem 80: Remove Duplicates from Sorted Array II
 */
public class RemoveDuplicatesSortedArray2 {

    public int removeDuplicates(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (!(prev1 == prev2 && prev2 == nums[i] && i >= 2)) {
                index++;
            }

            prev2 = prev1;
            prev1 = nums[i];
            nums[index] = nums[i];
        }

        return index + 1;
    }

    public static void main(String[] args) {
        int result = new RemoveDuplicatesSortedArray2().removeDuplicates(new int[] {1, 1, 1, 2, 2, 3});
        System.out.println(result);
    }
}

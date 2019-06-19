package easy;

import java.util.Arrays;

/**
 * Problem 27: Remove Element
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int index = 0;
        int k = 0;
        while (k < nums.length) {
            if (nums[k] != val) {
                nums[index++] = nums[k];
            }
            k++;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int result = new RemoveElement().removeElement(nums, 3);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }
}

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 18: 4Sum
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> solutions = new ArrayList<>();
        Arrays.sort(nums);

        int prevFirstValue = nums[0] + 1; // Any value != nums[0]
        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicate solutions where the first num is the same as before
            if (nums[i] == prevFirstValue) {
                continue;
            }
            prevFirstValue = nums[i];
            solutions.addAll(findFourSumWithFirstNum(nums, i, target));
        }
        return solutions;
    }

    // Essentially just a 3Sum
    private List<List<Integer>> findFourSumWithFirstNum(int[] nums, int first, int target) {
        List<List<Integer>> solutions = new ArrayList<>();
        target -= nums[first];

        int prevSecondValue = nums[first + 1] + 1; // Any value != the first nums[second]
        for (int i = first + 1; i < nums.length - 2; i++) {
            int second = i;
            // Skip duplicate solutions where the second num is the same as before
            if (nums[second] == prevSecondValue) {
                continue;
            }
            prevSecondValue = nums[second];
            int third = i + 1;
            int fourth = nums.length - 1;
            while (third < fourth) {
                int sum = nums[second] + nums[third] + nums[fourth];

                if (sum < target) {
                    third++;
                } else if (sum > target) {
                    fourth--;
                } else {
                    solutions.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));

                    // Get other solutions with last two nums while skipping duplicates
                    int temp3 = nums[third];
                    int temp4 = nums[fourth];
                    do {
                        third++;
                        fourth--;
                    } while (third < fourth && nums[third] == temp3 && nums[fourth] == temp4);
                }
            }
        }
        return solutions;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new FourSum().fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0);
        System.out.println(result);
    }
}

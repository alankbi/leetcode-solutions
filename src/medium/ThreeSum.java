package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Problem 15: 3Sum
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> values = new HashMap<>();
        Set<List<Integer>> uniqueTriplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            values.put(-nums[i], i);
        }

        // Loop through all combinations of 2 numbers while using values to provide
        // the third number and thus make the solution O(n^2) instead of O(n^3)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer third = values.get(nums[i] + nums[j]);

                // Can't reuse the same number twice
                if (third != null && third != i && third != j) {
                    List<Integer> solution = Arrays.asList(nums[i], nums[j], nums[third]);
                    Collections.sort(solution);

                    // Also can't have duplicate answers with
                    // numbers that appear more than once in nums
                    if (!uniqueTriplets.contains(solution)) {
                        uniqueTriplets.add(solution);
                        result.add(solution);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ThreeSum().threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }
}

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 47: Permutations II
 */
public class Permutations2 {

    private List<List<Integer>> solutions;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        solutions = new ArrayList<>();
        Map<Integer, Integer> counts = new HashMap<>();

        // Create frequency counts of each number
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 0);
            }
            counts.put(num, counts.get(num) + 1);
        }

        permute(nums, new ArrayList<>(), counts);
        return solutions;
    }

    private void permute(int[] nums, List<Integer> current, Map<Integer, Integer> counts) {
        if (current.size() >= nums.length) {
            solutions.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Avoid duplicate solutions
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (counts.get(nums[i]) > 0) {
                current.add(nums[i]);
                counts.put(nums[i], counts.get(nums[i]) - 1);
                permute(nums, current, counts);
                current.remove(current.size() - 1);
                counts.put(nums[i], counts.get(nums[i]) + 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Permutations2().permuteUnique(new int[] {1, 1, 2});
        System.out.println(result);
    }
}

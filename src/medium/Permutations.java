package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 46: Permutations
 */
public class Permutations {

    private List<List<Integer>> solutions;

    public List<List<Integer>> permute(int[] nums) {
        solutions = new ArrayList<>();
        permute(nums, 0, new ArrayList<>(), new boolean[nums.length]);
        return solutions;
    }

    private void permute(int[] nums, int count, List<Integer> current, boolean[] seen) {
        if (count >= nums.length) {
            solutions.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!seen[i]) {
                current.add(nums[i]);
                seen[i] = true;
                permute(nums, count + 1, current, seen);
                current.remove(current.size() - 1);
                seen[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Permutations().permute(new int[] {1, 2, 3});
        System.out.println(result);
    }
}

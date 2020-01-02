package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 78: Subsets
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(0, nums, result, new ArrayList<>());
        return result;
    }

    private void subsets(int index, int[] nums, List<List<Integer>> result, List<Integer> current) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            subsets(index + 1, nums, result, current);
            current.add(nums[index]);
            subsets(index + 1, nums, result, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Subsets().subsets(new int[] {1, 2, 3});
        System.out.println(result);
    }
}

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 39: Combination Sum
 */
public class CombinationSum {
    private List<List<Integer>> solutions;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solutions = new ArrayList<>();

        // Sort in descending order
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length / 2; i++) {
            int temp = candidates[i];
            candidates[i] = candidates[candidates.length - i - 1];
            candidates[candidates.length - i - 1] = temp;
        }

        combinationSum(candidates, target, 0, new ArrayList<>());
        return solutions;
    }

    private void combinationSum(int[] candidates, int target, int index, List<Integer> current) {
        if (target == 0) {
            solutions.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index >= candidates.length) {
            return;
        }

        int num = candidates[index];
        // Generate solutions without current element
        combinationSum(candidates, target, index + 1, current);
        // Generate solutions with all valid counts of current element
        int count = 0;
        while (target >= num) {
            target -= num;
            current.add(num);
            combinationSum(candidates, target, index + 1, current);
            count++;
        }

        // Remove elements when done with this recursion level
        for (int i = 0; i < count; i++) {
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSum().combinationSum(new int[] {2, 3, 5}, 8);
        System.out.println(result);
    }
}

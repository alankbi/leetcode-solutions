package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 40: Combination Sum II
 */
public class CombinationSum2 {
    private List<List<Integer>> solutions;

    @SuppressWarnings("Duplicates")
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        int duplicateCount = 0;
        while (index < candidates.length && candidates[index] == num) {
            duplicateCount++;
            index++;
        }

        // Generate solutions without current element
        combinationSum(candidates, target, index, current);
        // Generate solutions with all valid counts of current element
        for (int i = 0; i < duplicateCount; i++) {
            target -= num;
            current.add(num);
            combinationSum(candidates, target, index, current);
        }

        // Remove elements when done with this recursion level
        for (int i = 0; i < duplicateCount; i++) {
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSum2().combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(result);
    }
}

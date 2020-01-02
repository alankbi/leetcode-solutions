package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 77: Combinations
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        combine(n, k, 1, results, new ArrayList<>());
        return results;
    }

    private void combine(int n, int k, int index, List<List<Integer>> results, List<Integer> current) {
        if (current.size() == k) {
            results.add(new ArrayList<>(current));
        } else if (index <= n) {
            combine(n, k, index + 1, results, current);
            current.add(index);
            combine(n, k, index + 1, results, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Combinations().combine(2, 1);
        System.out.println(result);
    }
}

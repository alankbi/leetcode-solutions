package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 60: Permutation Sequence
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        List<Integer> available = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            available.add(i);
        }
        return getPermutation(n, k, available, new StringBuilder());
    }

    private String getPermutation(int n, int k, List<Integer> available, StringBuilder current) {
        if (n <= 0) {
            return current.toString();
        }

        int factorial = factorial(n - 1);
        int index = (k - 1) / factorial;
        k -= index * factorial;

        current.append(available.remove(index));
        return getPermutation(n - 1, k, available, current);
    }

    private int factorial(int n) {
        int num = 1;
        for (int i = 2; i <= n; i++) {
            num *= i;
        }
        return num;
    }

    public static void main(String[] args) {
        String result = new PermutationSequence().getPermutation(3, 3);
        System.out.println(result);
    }
}

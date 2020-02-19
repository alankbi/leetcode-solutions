package medium;

import java.util.Arrays;
import java.util.List;

/**
 * Problem 120: Triangle
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> layer = triangle.get(i);
            List<Integer> below = triangle.get(i + 1);
            for (int j = 0; j < layer.size(); j++) {
                layer.set(j, layer.get(j) + Math.min(below.get(j), below.get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );

        int result = new Triangle().minimumTotal(triangle);
        System.out.println(result);
    }
}
